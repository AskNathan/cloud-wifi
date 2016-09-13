package cn.cnsjwx.facade.permissions.service.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.facade.permissions.entity.Acl;
import cn.cnsjwx.facade.permissions.entity.Menu;
import cn.cnsjwx.facade.permissions.entity.Principal;
import cn.cnsjwx.facade.permissions.service.AclService;
import cn.cnsjwx.facade.permissions.vo.AuthVO;
import cn.cnsjwx.facade.user.entity.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Acl Service 实现
 * Created by Nathan on 2016-09-08.
 */
@Service("aclService")
public class AclServiceImpl implements AclService {

    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

    private String menuMapper = Menu.class.getName();

    private String mapper = Acl.class.getName();

    private String userAdminMapper = UserAdmin.class.getName();

    @Autowired
    private BaseDao<Menu> menuyDao;

    @Autowired
    private BaseDao<Acl> aclDao;

    @Autowired
    private BaseDao<UserAdmin> userAdminDao;


    /**
     * 根据用户Id 查询具有访问权限的菜单资源
     *
     * @param userId
     * @return
     */
    @Override
    public List<Menu> findPermitMenus(String userId) {
        List<Menu> menus = menuyDao.getList(menuMapper + "Mapper.findAllPermitMenus", null);

        removeDenyMenus(menus, userId);

        return menus;
    }

    /**
     * 删除不允许的菜单项
     *
     * @param menus
     * @param userId
     */
    private void removeDenyMenus(Collection<Menu> menus, String userId) {

        /**
         * 遍历当前菜单项
         */
        for (Iterator<Menu> iterator = menus.iterator(); iterator.hasNext();) {

            Menu menu = iterator.next();

            UserAdmin userAdmin = userAdminDao.get(userAdminMapper + "Mapper.findUserAdminById", userId);

			/* 查询用户针对此菜单的权限 */
            AuthVO vo = searchAcl(userAdmin.getPrincipalType(), userAdmin.getId(), menu.getResourceType(), menu.getResourceId(), menu.getOpersIndex()[0],
                    userAdmin.getParentPrincipal());

            /**
             * 如果次菜单未授权,或者已授权不允许访问则移除本菜单
             */
            if (vo == null || !vo.isPermit()) {

                iterator.remove();
            }

        }

    }

    /**
     * 根据主体获得授权的信息
     * @param principalType
     * @param principalId
     * @param resourceType
     * @param resourceId
     * @param operIndex
     * @param parents
     * @return
     */
    private AuthVO searchAcl(String principalType, String principalId, String resourceType, String resourceId, int operIndex, Map<Object, String> parents) {

        /**
         * 参数的封装
         */
        Map<String, Object> param = new HashMap<String, Object>(4);
        param.put("principalType", principalType);
        param.put("principalId", principalId);
        param.put("resourceType", resourceType);
        param.put("resourceId", resourceId);

        Acl acl = aclDao.get(mapper + "Mapper.findAcl", param);

        AuthVO authVo = null;

        /**
         * 如果授权,而且不是继承,则马上得到授权信息
         */
        if (acl != null && !acl.isExt(operIndex)) {
            authVo = new AuthVO();
            authVo.setResourceId(resourceId);
            authVo.setOperIndex(operIndex);
            authVo.setExt(false);
            authVo.setPermit(acl.isPermit(operIndex));
            return authVo;
        }

        if (parents == null) {
            return null;
        }

        /**
         * 遍历父亲主体
         */
        for (Map.Entry<Object, String> entry : parents.entrySet()) {

            Object o = entry.getKey();

            Principal parent = (Principal) o;

            AuthVO pvo = searchAcl(parent.getPrincipalType(), entry.getValue(), resourceType, resourceId, operIndex, parent.getParentPrincipal());

            /**
             * 如果父亲有授权,而且是拒绝的,则返回
             */
            if (pvo != null && !pvo.isPermit()) {

                authVo = new AuthVO();
                authVo.setResourceId(resourceId);
                authVo.setOperIndex(operIndex);
                authVo.setExt(true);
                authVo.setPermit(false);
                return authVo;
            }

            /**
             * 如果父亲有授权,而且是允许的
             */
            if (pvo != null && pvo.isPermit()) {

                if (authVo == null) {
                    authVo = new AuthVO();
                    authVo.setResourceId(resourceId);
                    authVo.setOperIndex(operIndex);
                    authVo.setExt(true);
                    authVo.setPermit(true);
                }

            }
        }
        return authVo;

    }

    /**
     * 根据角色Id,查询具有访问权限的菜单资源
     * @param roleId
     * @return
     */
    @Override
    public List<Menu> findPermitMenusByRoleId(String roleId) {
        List<Acl> acls = findRoleMenuByPrincipalId("Role", roleId, "Menu", 1);
        List<Menu> menus = new ArrayList<Menu>(acls.size());
        for(Acl acl : acls){
            Menu menu = menuyDao.get(menuMapper+"Mapper.findMenuById", acl.getResourceId());
            menus.add(menu);
        }
        return menus;    }

    /**
     * 给某种主体授权
     * @param principalType
     * @param principalId
     * @param resourceType
     * @param acls
     * @return
     */
    @Override
    public void addOrUpdatePermission(String principalType, String principalId, String resourceType, List<AuthVO> acls) {

        try {
            Acl param = new Acl();
            param.setPrincipalId(principalId);
            param.setPrincipalType(principalType);
            param.setResourceType(resourceType);
            /**
             * 删除所有授权
             */
            aclDao.delete(mapper + "Mapper.delAcls", param);
            if (acls != null && acls.size() > 0) {
                for (AuthVO auth : acls) {
                    String resourceId = auth.getResourceId();
                    int operIndex = auth.getOperIndex();
                    boolean permit = auth.isPermit();
                    boolean ext = auth.isExt();
                    Acl acl = new Acl();
                    acl.setPrincipalType(principalType);
                    acl.setPrincipalId(principalId);
                    acl.setResourceType(resourceType);
                    acl.setResourceId(resourceId);
                    acl.setPermission(operIndex, permit, ext);
                    aclDao.save(mapper + "Mapper.insert", acl);
                }
            }
        } catch (DataBaseAccessException e) {
            logger.error("addorUpdatePermission", e);
        }
    }

    /**
     * 根据主体类型,主体ID,资源类型获取Menu
     *
     * @param principalType
     * @param principalId
     * @param resourceType
     * @param aclState
     * @return
     */
    @Override
    public List<Acl> findRoleMenuByPrincipalId(String principalType, String principalId, String resourceType, int aclState) {
        Map<String, Object> param = new HashMap<String, Object>(4);
        param.put("principalType", principalType);
        param.put("principalId", principalId);
        param.put("resourceType", resourceType);
        param.put("aclState", aclState);
        return aclDao.getList(mapper+"Mapper.findAclByPrincipalId", param);    }
}

package cn.cnsjwx.facade.permissions.service.impl;
import cn.cnsjwx.common.core.dao.BaseDao;
import cn.cnsjwx.common.exceptions.DataBaseAccessException;
import cn.cnsjwx.common.logger.SimpleLogger;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.permissions.entity.Role;
import cn.cnsjwx.facade.permissions.service.AclService;
import cn.cnsjwx.facade.permissions.service.RoleService;
import cn.cnsjwx.facade.permissions.vo.AuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Role 的接口实现
 * Created by Nathan on 2016-09-08.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private SimpleLogger logger = SimpleLogger.getLogger(this.getClass());

    private String mapper = Role.class.getName();

    @Autowired
    private BaseDao<Role> roleDao;

    @Autowired
    private AclService aclService;


    /**
     * add
     * @param role
     * @param menuId
     * @return
     */
    @Override
    public Boolean addRole(Role role, String[] menuId) {
        try {
            if (roleDao.save(mapper + "Mapper.insert", role) > 0) {
                List<AuthVO> list = new ArrayList<AuthVO>();
                for (int i = 0; i < menuId.length; i++) {
                    AuthVO av = new AuthVO();
                    av.setPermit(true);
                    av.setExt(false);
                    av.setOperIndex(0);
                    av.setResourceId(menuId[i]);
                    list.add(av);
                }
                aclService.addOrUpdatePermission("Role", role.getId(), "Menu", list);
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("Create Role DataBaseAccessException", e);
        }
        return Boolean.FALSE;
    }

    /**
     * update
     * @param role
     * @param menuId
     * @return
     */
    @Override
    public Boolean updateRole(Role role, String[] menuId) {
        try {
            if (roleDao.update(mapper + "Mapper.update", role) > 0) {
                List<AuthVO> list = new ArrayList<AuthVO>();
                for (int i = 0; i < menuId.length; i++) {
                    AuthVO av = new AuthVO();
                    av.setPermit(true);
                    av.setExt(false);
                    av.setOperIndex(0);
                    av.setResourceId(menuId[i]);
                    list.add(av);
                }
                aclService.addOrUpdatePermission("Role", role.getId(), "Menu", list);
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("Update Role DataBaseAccessException", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 根据id删除role
     * @param list
     * @return
     */
    @Override
    public Boolean delRoleByIds(List<String> list) {
        try {
            if (roleDao.delete(mapper + "Mapper.delByIds", list) > 0) {
                return Boolean.TRUE;
            }
        } catch (DataBaseAccessException e) {
            logger.error("delByIds Role DataBaseAccessException", e);
        }
        return Boolean.FALSE;
    }

    /**
     * 查询企业的Role
     * @param role
     * @return
     */
    @Override
    public List<Role> findRoleByCompanyId(Role role) {
        return roleDao.getList(mapper + "Mapper.findRoleByCompanyId", role);
    }

    /**
     * 根据企业Id和name查询Role
     * @param role
     * @return
     */
    @Override
    public List<Role> findRoleByName(Role role) {
        return roleDao.getList(mapper + "Mapper.findRoleByName", role);
    }

    /**
     * 根据企业ID和code查询Role
     * @param role
     * @return
     */
    @Override
    public List<Role> findRoleByCode(Role role) {
        return roleDao.getList(mapper + "Mapper.findRoleByCode", role);
    }

    /**
     * paging
     * @param role
     * @param page
     * @return
     */
    @Override
    public Page<Role> findRoleByParam(Role role, Page<Role> page) {
        return roleDao.getList(mapper + "Mapper.findRoleByParam", role, page);
    }
}

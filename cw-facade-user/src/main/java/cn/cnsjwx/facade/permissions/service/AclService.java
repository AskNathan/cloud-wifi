package cn.cnsjwx.facade.permissions.service;

import cn.cnsjwx.facade.permissions.entity.Acl;
import cn.cnsjwx.facade.permissions.entity.Menu;
import cn.cnsjwx.facade.permissions.vo.AuthVO;

import java.util.List;
/**
 * Acl service 接口定义
 * Created by Nathan on 2016-09-08.
 */
public interface AclService {

    /**
     * 根据用户Id 查询具有访问权限的菜单资源
     * @param userId
     * @return
     */
    public List<Menu> findPermitMenus(String userId);

    /**
     * 根据角色Id,查询具有访问权限的菜单资源
     * @param roleId
     * @return
     */
    public List<Menu> findPermitMenusByRoleId(String roleId);

    /**
     * 给某种主体授权
     * @param principalType
     * @param principalId
     * @param resourceType
     * @param acls
     * @return
     */
    public void addOrUpdatePermission(String principalType, String principalId, String resourceType, List<AuthVO> acls);

    /**
     * 根据主体类型,主体ID,资源类型获取Menu
     * @param principalType
     * @param principalId
     * @param resourceType
     * @return
     */
    public List<Acl> findRoleMenuByPrincipalId(String principalType, String principalId, String resourceType, int aclState);
}

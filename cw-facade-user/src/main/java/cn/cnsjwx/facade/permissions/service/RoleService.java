package cn.cnsjwx.facade.permissions.service;
import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.permissions.entity.Role;
import cn.cnsjwx.facade.user.entity.UserAdmin;
import java.util.List;

/**
 * 角色接口定义
 * Created by Nathan on 2016-09-08.
 */
public interface RoleService {

    /**
     * add
     * @param role
     * @param menuId
     * @return
     */
    public Boolean addRole(Role role, String[] menuId);

    /**
     * update
     * @param role
     * @return
     */
    public Boolean updateRole(Role role, String[] menuId);

    /**
     * 根据id删除role
     * @param list
     * @return
     */
    public Boolean delRoleByIds(List<String> list);

    /**
     * 查询企业的Role
     * @param role
     * @return
     */
    public List<Role> findRoleByCompanyId(Role role);

    /**
     * 根据企业Id和name查询Role
     * @param role
     * @return
     */
    public List<Role> findRoleByName(Role role);

    /**
     * 根据企业ID和code查询Role
     * @param role
     * @return
     */
    public List<Role> findRoleByCode(Role role);

    /**
     * paging
     * @param role
     * @param page
     * @return
     */
    public Page<Role> findRoleByParam(Role role, Page<Role> page);
}

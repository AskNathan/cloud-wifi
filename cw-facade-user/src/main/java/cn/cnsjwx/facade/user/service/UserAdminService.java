package cn.cnsjwx.facade.user.service;

import cn.cnsjwx.common.page.Page;
import cn.cnsjwx.facade.user.entity.UserAdmin;
import cn.cnsjwx.facade.user.vo.UserAdminVo;

import java.util.List;

/**
 * UserAdminService接口定义
 * Created by Nathan on 2016-09-08.
 */
public interface UserAdminService {

    /**
     * 根据Id 查找UserAdmin
     * @param id
     * @return
     */
    public UserAdmin findUserAdminById(String id);

    /**
     * 根据CompanyId查找UserAdmin
     * @param companyId
     * @return
     */
    public UserAdmin findUserAdminByCompanyId(String companyId);

    /**
     * 根据loginname 查找UserAdmin
     * @param loginname
     * @return
     */
    public UserAdmin findUserAdminByLoginname(String loginname);

    /**
     * 企业管理员在企业内登录名称唯一
     * @param userAdmin
     * @return
     */
    public UserAdmin checkLoginnameInCompany(UserAdmin userAdmin);

    /**
     * 企业超管在超管内登录名称唯一
     * @param userAdmin
     * @return
     */
    public UserAdmin checkLoginnameInComAdmin(UserAdmin userAdmin);

    /**
     * CRM对接使用到：
     * 根据必选的企业CompanyId，必选的登录名称loginname,可选的角色roleId,可选的账户类型type判断
     * @param userAdmin
     * @return
     */
    public UserAdmin findSuperUAByCompanyIdAndType(UserAdmin userAdmin);

    /**
     * 根据companyId 更新UserAdmin
     * @param userAdmin
     * @return
     */
    public Boolean updateUserAdminByCompanyId(UserAdmin userAdmin);

    /**
     *  根据id 更新UserAdmin
     * @param userAdmin
     * @return
     */
    public Boolean updateUserAdminById(UserAdmin userAdmin);



    /**
     * CRM对接时：变更CRM创建的唯一正式账户企业超管UserAdmin
     * 根据 CompanyID,可选的角色roleId,可选的账户类型type变更企业的登录名称loginname,用户名称username,启用状态eable,电话phone
     * @param userAdmin
     * @return
     */
    public UserAdmin updateStatusByRoleIDAndCompanyID(UserAdmin userAdmin);

    /**
     * 根据各参数查询UserAdminVo
     * @param params
     * @param page
     * @return
     */
    public Page<UserAdminVo> findUserAdminVoByParam(UserAdminVo params, Page<UserAdminVo> page);

    /**
     * 根据各参数查询UserAdmin
     * @param params
     * @param page
     * @return
     */
    public Page<UserAdmin> findUserAdminByParam(UserAdmin params,Page<UserAdmin> page);

    /**
     * 增加UserAdmin
     * @param userAdmin
     * @return
     */
    public Boolean addUserAdmin(UserAdmin userAdmin);

    /**
     * del UserAdmin by id
     * @param id
     * @return
     */
    public Boolean delUserAdmin(String id);

    /**
     * del UserAdmin by ids
     * @param ids
     * @return
     */
    public Boolean delUserAdminByIds(List<String> ids);

}

package cn.cnsjwx.facade.user.entity;
import cn.cnsjwx.common.entity.BaseEntity;
import cn.cnsjwx.facade.permissions.entity.Principal;
import cn.cnsjwx.facade.permissions.entity.Role;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 后端用户
 * Created by Nathan on 2016-09-08.
 */
public class UserAdmin extends BaseEntity implements Principal {


    private static final long serialVersionUID = -3762864654318298747L;

    /** 登录名称 */
    private String loginname;

    /** 登录名称*/
    private String password;

    /** 用户名称*/
    private String username;

    /** 电子邮件*/
    private String email;

    /** 联系电话*/
    private String phone;

    /** 职位*/
    private String position;

    /**
     * 状态
     * 0启用
     * 1不启用
     */
    private Integer status;

    /**
     * 账户类型
     * 0 试用用户
     * 1正式用户
     */
    private Integer type;

    /** 创建日期*/
    private Date datetime;

    /** 企业Id*/
    private String companyId;

    /** 角色Id*/
    private String roleId;


    /**
     * 获得主体的Id
     *
     * @return
     */
    @Override
    public String getPrincipalId() {
        return super.getId();
    }

    /**
     * 获得主体的类型
     *
     * @return
     */
    @Override
    public String getPrincipalType() {
        return "UserAdmin";
    }

    /**
     * key:父主体的类型
     * value:父主体的Id
     *
     * @return
     */
    @Override
    public Map<Object, String> getParentPrincipal() {
        Map<Object,String> map = new HashMap<Object,String>(1);
        Role role = new Role();
        map.put(role, roleId);
        return map;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

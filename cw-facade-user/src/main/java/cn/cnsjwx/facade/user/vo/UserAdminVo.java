package cn.cnsjwx.facade.user.vo;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nathan on 2016-09-08.
 */
public class UserAdminVo implements Serializable {

    private static final long serialVersionUID = -1799855147491069018L;

    /** id */
    private String id;

    /** 登录名称 */
    private String loginname;

    /** 用户名称*/
    private String username;

    /** 电子邮件*/
    private String email;

    /** 联系电话*/
    private String phone;

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

    /** 企业名称 */
    private String companyName;

    /** 角色Id*/
    private String roleId;

    /**角色名称*/
    private String roleName;

    /**职位*/
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

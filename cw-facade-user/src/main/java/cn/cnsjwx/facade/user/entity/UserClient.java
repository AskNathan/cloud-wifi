package cn.cnsjwx.facade.user.entity;
import cn.cnsjwx.common.entity.BaseEntity;
import java.math.BigInteger;

/**
 * 前段用户
 * Created by Nathan on 2016-09-08.
 */
public class UserClient extends BaseEntity{

    private static final long serialVersionUID = -7702155023712742148L;

    /** 登录名称*/
    private String loginname;

    /** 用户名称 */
    private String username;

    /** 密码*/
    private String password;

    /** 电子邮件*/
    private String email;

    /** 联系电话*/
    private String phone;

    /** 用户头像*/
    private String image;

    /** 手机IMSI*/
    private String imsi;

    /** 客户端Mac*/
    private String mac;

    /** 随机码*/
    private String rnum;

    /**
     * 状态
     * 0 可用
     * 1 禁止
     */
    private Integer status;

    /**
     * 账户类型
     * 0 试用用户
     * 1正式用户
     */
    private Integer type;

    /** push的 userId */
    private String userId;

    /** 通道的Id */
    private BigInteger channelId;

    /**
     * 设备类型
     * 0 IOS
     * 1 Android
     */
    private Integer deviceType;

    /** 部门Id */
    private String departmentId;

    /** 企业Id*/
    private String companyId;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigInteger getChannelId() {
        return channelId;
    }

    public void setChannelId(BigInteger channelId) {
        this.channelId = channelId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}

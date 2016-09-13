package cn.cnsjwx.facade.permissions.entity;
import cn.cnsjwx.common.entity.BaseEntity;
import java.util.Date;
import java.util.Map;
/**
 * 角色
 * Created by Nathan on 2016-09-08.
 */
public class Role extends BaseEntity implements Principal{

    /** 角色名称*/
    private String name;

    /** 角色编码*/
    private String code;

    /** 创建时间*/
    private Date datetime;

    /** 企业Id*/
    private String companyId;

    /**
     * 获得主体的Id
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
        return "Role";
    }

    /**
     * key:父主体的类型
     * value:父主体的Id
     *
     * @return
     */
    @Override
    public Map<Object, String> getParentPrincipal() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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


}

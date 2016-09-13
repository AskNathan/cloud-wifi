package cn.cnsjwx.facade.system.vo;
import java.io.Serializable;
import java.util.Date;
/**
 * DepartmentVo含有上级部门
 * Created by Nathan on 2016-09-08.
 */
public class DepartmentVo implements Serializable{

    private static final long serialVersionUID = 2629334690941249347L;

    /** 部门的Id*/
    private String id;

    /** 名称*/
    private String name;

    /** 描述*/
    private String desc;

    /** 排序编码*/
    private Integer order;

    /** 创建日期*/
    private Date datetime;

    /** 父Id*/
    private String pid;

    /** 父部门名称  */
    private String pName;

    /** 企业Id*/
    private String companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}

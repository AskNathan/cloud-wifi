package cn.cnsjwx.facade.system.entity;

import cn.cnsjwx.common.entity.BaseEntity;

/**
 * Created by Nathan on 2016-09-08.
 */
public class Department extends BaseEntity {

    private static final long serialVersionUID = 1393890502600942796L;

    /** 名称*/
    private String name;

    /** 描述*/
    private String desc;

    /** 排序编码*/
    private Integer order;

    /** 父Id*/
    private String pid;

    /** 企业Id*/
    private String companyId;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}

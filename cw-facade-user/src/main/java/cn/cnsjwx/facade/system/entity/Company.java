package cn.cnsjwx.facade.system.entity;

import cn.cnsjwx.common.entity.BaseEntity;

import java.util.Date;

/**
 * Created by Nathan on 2016-09-08.
 */
public class Company extends BaseEntity {

    private static final long serialVersionUID = -6687342618990039218L;

    /** 名称*/
    private String name;

    /** 编码*/
    private String code;

    /**
     * 0:启用
     * 1:不启用
     */
    private Integer enable;

    /**
     * 0 试用企业
     * 1 正式企业
     */
    private Integer tryStatus;


    /** 有效日期*/
    private Date effDate;

    /** 备注*/
    private String remark;

    /** 父id*/
    private String pid;

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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getTryStatus() {
        return tryStatus;
    }

    public void setTryStatus(Integer tryStatus) {
        this.tryStatus = tryStatus;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

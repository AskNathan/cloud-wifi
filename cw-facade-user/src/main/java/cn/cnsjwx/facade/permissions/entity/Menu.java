package cn.cnsjwx.facade.permissions.entity;

import cn.cnsjwx.common.entity.BaseEntity;

import java.util.Date;
import java.util.Map;

/**
 * 菜单
 * Created by Nathan on 2016-09-08.
 */
public class Menu extends BaseEntity implements SysResource{

    private static final long serialVersionUID = 3561410832858724898L;

    /** 名称*/
    private String name;

    /** 地址*/
    private String url;

    /** 排序*/
    private Integer order;

    /**
     * 0显示
     * 1不显示
     */
    private Integer display;

    /** 唯一标示*/
    private String sn;

    /** 创建日期*/
    private Date datetime;

    /** 父Id*/
    private String pid;

    /**
     * 获得资源的Id
     *
     * @return
     */
    @Override
    public String getResourceId() {
        return super.getId();
    }

    /**
     * 获得资源的Type
     *
     * @return
     */
    @Override
    public String getResourceType() {
        return "Menu";
    }

    /**
     * 获得操作的索引值
     *
     * @return
     */
    @Override
    public int[] getOpersIndex() {
        return new int[0];
    }

    /**
     * 获得操作的唯一标示Sn
     *
     * @param operSn
     * @return
     */
    @Override
    public int getOperIndexBySn(String operSn) {
        return 0;
    }

    /**
     * 获得所有操作的子资源
     *
     * @return
     */
    @Override
    public Map<Object, String> getChildrenResource() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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
}

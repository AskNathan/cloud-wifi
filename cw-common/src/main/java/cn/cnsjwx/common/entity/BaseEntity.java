package cn.cnsjwx.common.entity;
import cn.cnsjwx.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @描述: 基础实体类，包含各实体公用属性 .
 * @创建时间: 2013-7-28,下午8:53:52 .
 * @版本: 1.0 .
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键Id */
	private String id;

	/** 版本控制*/
	private Integer version = 0;

	/** 创建者*/
	private String createBy;

	/** 创建时间*/
	private Date createTime;

	/** 更新者*/
	private String updateBy;

	/** 更新时间*/
	private Date updateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

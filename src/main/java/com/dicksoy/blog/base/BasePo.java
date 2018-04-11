package com.dicksoy.blog.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * po基类
 * @author Dicksoy
 * @date 2017年7月21日 下午5:30:43
 * @version
 */
public class BasePo extends Model<BasePo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1016882831276145369L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	@TableField("create_time")
	private Date createTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

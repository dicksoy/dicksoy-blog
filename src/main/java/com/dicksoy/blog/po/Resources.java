package com.dicksoy.blog.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.dicksoy.blog.base.BasePo;

@TableName("t_resources")
public class Resources extends BasePo {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@TableField("resources_url")
	private String resourcesUrl;
	
	private Integer type;
	
	@TableField("parent_id")
	private Integer parentId;
	
	private Integer sort;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourcesUrl() {
		return resourcesUrl;
	}

	public void setResourcesUrl(String resourcesUrl) {
		this.resourcesUrl = resourcesUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}

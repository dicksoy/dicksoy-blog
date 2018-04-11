package com.dicksoy.blog.dto;

import com.dicksoy.blog.po.Resources;

public class ResourcesDto extends Resources {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userIdPK;
	
	private Integer type;

	public ResourcesDto() {
		super();
	}

	public ResourcesDto(Long userIdPK) {
		super();
		this.userIdPK = userIdPK;
	}

	public Long getUserIdPK() {
		return userIdPK;
	}

	public void setUserIdPK(Long userIdPK) {
		this.userIdPK = userIdPK;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}

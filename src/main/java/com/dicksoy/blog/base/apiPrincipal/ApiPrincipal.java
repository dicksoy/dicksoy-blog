package com.dicksoy.blog.base.apiPrincipal;

import java.io.Serializable;

public class ApiPrincipal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String host;
	private String userId;
	
	public ApiPrincipal() {
		super();
	}

	public ApiPrincipal(String userId) {
		super();
		this.userId = userId;
	}

	public ApiPrincipal(String username, String userId) {
		this.username = username;
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

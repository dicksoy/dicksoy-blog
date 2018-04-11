package com.dicksoy.blog.vo;

import com.dicksoy.blog.po.Article;

public class ArticleVo extends Article {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String theirName;

	public String getTheirName() {
		return theirName;
	}

	public void setTheirName(String theirName) {
		this.theirName = theirName;
	}
}

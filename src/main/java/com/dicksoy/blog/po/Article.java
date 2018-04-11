package com.dicksoy.blog.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.dicksoy.blog.base.BasePo;

@TableName("t_blog_article")
public class Article extends BasePo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	
	private String description;

	private String content;

	private Integer type;
	
	private Integer sort;

	@TableField("user_id")
	private String userId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

package com.dicksoy.blog.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.dicksoy.blog.base.BasePo;

@TableName("t_aphorism")
public class Aphorism extends BasePo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableField("aphorism_english")
	private String aphorismEnglish;
	
	@TableField("aphorism_chinese")
	private String aphorismChinese;
	
	@TableField("create_user")
	private String createUser;
	
	private Integer sort;

	public String getAphorismEnglish() {
		return aphorismEnglish;
	}

	public void setAphorismEnglish(String aphorismEnglish) {
		this.aphorismEnglish = aphorismEnglish;
	}

	public String getAphorismChinese() {
		return aphorismChinese;
	}

	public void setAphorismChinese(String aphorismChinese) {
		this.aphorismChinese = aphorismChinese;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}

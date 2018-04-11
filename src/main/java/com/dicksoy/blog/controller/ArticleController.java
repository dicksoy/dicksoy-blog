package com.dicksoy.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.dicksoy.blog.base.BaseController;
import com.dicksoy.blog.base.apiPrincipal.ApiPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dicksoy.blog.base.BaseResult;
import com.dicksoy.blog.po.Article;
import com.dicksoy.blog.service.ArticleService;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{

	@Resource
	private ArticleService articleService;
	
	@GetMapping("/queryArticleListByCondition")
	@ResponseBody
	public BaseResult queryArticleListByCondition(Article article) {
		JSONObject columnMap = (JSONObject) JSONObject.toJSON(article);
		List<Article> list = articleService.selectByMap(columnMap);
		return BaseResult.builder().code(200).msg("成功").result(list);
	}

	@PostMapping("/articleListBack")
	@ResponseBody
	public BaseResult articleListBack(ApiPrincipal apiPrincipal) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_id", apiPrincipal.getUserId());
		List<Article> list = articleService.selectByMap(params);
		return BaseResult.builder().code(OK).msg(DEFAULT_SUCCESS_MGS).result(list);
	}

	@GetMapping("/queryById")
	public String queryById(Long id, Model model) {
		Article result = articleService.selectById(id);
		String theirName = "";
		if (result.getType() == 1)
			theirName = "Dicksoy";
		if (result.getType() == 2)
			theirName = "Danish";
		model.addAttribute("article", result);
		model.addAttribute("theirName", theirName);
		return "article";
	}
	
	@GetMapping("/queryByPage")
	public String queryById(Long id, Model model, Integer current, Integer size) {
		Page<Article> page = new Page<Article>(current, size, "create_time");
		EntityWrapper<Article> wrapper = new EntityWrapper<Article>();
		Page<Article> result = articleService.selectPage(page, wrapper);
		return "article";
	}
	
	/**
	 * TODO
	 * 发布文章
	 * @return
	 */
	@PostMapping("/publishArticle")
	public BaseResult publishArticle(Article article) {
		if (article == null) {
			return BaseResult.builder().code(500).msg("参数错误");
		}
		return BaseResult.builder().code(200).msg("成功").result(null);
	}
}

package com.dicksoy.blog.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dicksoy.blog.base.apiPrincipal.ApiPrincipal;
import com.dicksoy.blog.service.ResourcesService;

@RestController
@RequestMapping("test")
public class TestController {

	@Resource
	private ResourcesService resourcesService;
	
	@RequestMapping("test")
	public Object test(ApiPrincipal apiPrincipal) {
		return apiPrincipal;
	}
}

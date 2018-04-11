package com.dicksoy.blog.controller.back;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("/error")  
public class MyErrorController{  
	
	private static final Logger log = LoggerFactory.getLogger(MyErrorController.class);  
	
	private static final String ERROR_PATH="/";  
	
	@RequestMapping(value = ERROR_PATH )
	public String handleError(ServletRequest request, ServletResponse rsp) {  
		log.info("其它错误~");  
		return "error/error";  
	}  
	
	@RequestMapping(value ="/403" )  
	public String error403(ServletRequest request, ServletResponse rsp) {  
		log.info("403错误~");  
		return "error/403";  
	}  
	
	@RequestMapping(value ="/404" )  
	public String error404(ServletRequest request, ServletResponse rsp) {  
		log.info("404错误~");  
		return "error/404";  
	}  
	@RequestMapping(value ="/500" )  
	public String error500(ServletRequest request, ServletResponse rsp) {  
		log.info("500错误~");  
		return "error/500";  
	}  
	
	@RequestMapping(value ="/locked" )  
	public String errorlocked(ServletRequest request, ServletResponse rsp) {  
		log.info("locked~");  
		return "error/locked";  
	}  
	
	@RequestMapping(value ="/noauth" )  
	public String errornoauth(ServletRequest request, ServletResponse rsp) {  
		log.info("noauth~");  
		return "error/noauth";  
	}  
} 
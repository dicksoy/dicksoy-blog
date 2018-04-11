package com.dicksoy.blog.config;


import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置文件大小限制，超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了
		factory.setMaxFileSize("10240KB");
		// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		// Sets the directory location where files will be stored
		// factory.setLocation("路径地址")
		return factory.createMultipartConfig();
	}
}

package com.dicksoy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.dicksoy.blog.dao")
@ComponentScan
@SpringBootApplication
@EnableCaching(proxyTargetClass = false) // 开启缓存功能
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication();
		app.setRegisterShutdownHook(true);
		int s = 0;
		int s1 = 1;
		
		app.run(BlogApplication.class, args);
		
	}
}

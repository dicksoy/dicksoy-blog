package com.dicksoy.blog.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Druid的DataResource配置类
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")
 * 获取application配置文件中的变量。 这里采用第一种要方便些
 */
public class DruidDataSourceConfig implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
		dataSource.setUsername(propertyResolver.getProperty("username"));
		dataSource.setPassword(propertyResolver.getProperty("password"));
		dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initial-size")));
		dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("min-idle")));
		dataSource.setMaxWait(Long.valueOf(propertyResolver.getProperty("max-wait")));
		dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("max-active")));
		dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("min-evictable-idle-time-millis")));
		try {
			dataSource.setFilters("stat,wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

}

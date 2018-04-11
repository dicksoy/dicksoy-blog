package com.dicksoy.blog.config;

import java.util.List;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dicksoy.blog.base.apiPrincipal.ApiPrincipalMethodArgumentResolver;
import com.dicksoy.blog.config.interceptor.MyInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor());
		super.addInterceptors(registry);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new ApiPrincipalMethodArgumentResolver());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).ignoreAcceptHeader(true)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("json", MediaType.APPLICATION_JSON_UTF8);
	}

	@Override  
	public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");  
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");  
        super.addResourceHandlers(registry);
	}

	/**
	 * TODO json会被下载
	 * 消息内容转换配置
	 * 配置fastJson返回json转换
	 * @param converters
	 */
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类的配置
		super.configureMessageConverters(converters);
		//创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//修改配置返回内容的过滤
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty
				);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//将fastjson添加到视图消息转换器列表内
		converters.add(fastConverter);
	}*/

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// log.info( "==添加错误状态处理页面==" );  
		/*container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));  */
	}
}

package com.dicksoy.blog.base.apiPrincipal;

import com.dicksoy.blog.base.BaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSONObject;
import com.dicksoy.blog.base.SpringUtil;
import com.dicksoy.blog.config.redis.RedisManager;
import com.dicksoy.blog.exception.ApiPrincipalException;

public class ApiPrincipalMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiPrincipalMethodArgumentResolver.class);
	
	private RedisManager redisManager;
	
	public ApiPrincipalMethodArgumentResolver() {
		LOGGER.info("{ApiPrincipalMethodArgumentResolver} init success ...");
	}

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().isAssignableFrom(ApiPrincipal.class);
	}
	
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
	        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws ApiPrincipalException {
		redisManager = (RedisManager) SpringUtil.getBean("redisManager");
		ApiPrincipal apiPrincipal = JSONObject.parseObject(redisManager.get(BaseConstant.REDIS_SESSION_PREFIX + webRequest.getSessionId()), ApiPrincipal.class);
		if (apiPrincipal == null) {
			throw new ApiPrincipalException("用户信息失效，请重新登录");
		}
		return apiPrincipal;
	}
}

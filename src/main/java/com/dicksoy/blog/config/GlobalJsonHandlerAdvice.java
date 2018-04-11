package com.dicksoy.blog.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dicksoy.blog.base.BaseResult;
import com.dicksoy.blog.exception.ApiPrincipalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.io.PrintWriter;


@ControllerAdvice
public class GlobalJsonHandlerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalJsonHandlerAdvice.class);

	private ObjectMapper mapper = new ObjectMapper();

	public GlobalJsonHandlerAdvice() {
		LOGGER.info("{GlobalJsonHandlerAdvice} 全局异常处理类初始化成功...");
	}

	@ExceptionHandler(ApiPrincipalException.class)
	public void handleException(HttpServletRequest request, HttpServletResponse response, ApiPrincipalException e) throws Exception {
		LOGGER.error("当前请求url : " + request.getRequestURI());
		LOGGER.error("错误信息 : " + e.getMessage());
		handleError(BaseResult.builder().code(BaseResult.Code.UN_AUTH).msg(BaseResult.Message.UN_AUTH_CODE_ERROR_MSG), response);
	}

	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		LOGGER.error("当前请求url : " + request.getRequestURI());
		LOGGER.error("错误信息 : " + e.getMessage());
		handleError(BaseResult.builder().code(BaseResult.Code.ERROR).msg(BaseResult.Message.DEFAULT_SERVER_ERROR_MSG), response);
	}

	private void handleError(Object result, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			mapper.writeValue(out, result);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out != null)
				out.close();
		}
	}
}

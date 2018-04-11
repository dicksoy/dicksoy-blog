package com.dicksoy.blog.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller基类
 * 静态常量Message, Code
 */
public class BaseController implements BaseResult.Message, BaseResult.Code {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

}

package com.dicksoy.blog.service;

import com.baomidou.mybatisplus.service.IService;
import com.dicksoy.blog.po.Aphorism;

public interface AphorismService extends IService<Aphorism> {

	Aphorism selectOneRandom();
}

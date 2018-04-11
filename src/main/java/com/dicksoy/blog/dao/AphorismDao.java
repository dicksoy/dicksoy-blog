package com.dicksoy.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dicksoy.blog.po.Aphorism;

public interface AphorismDao extends BaseMapper<Aphorism> {

	Aphorism selectOneRandom();
}

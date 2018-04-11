package com.dicksoy.blog.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dicksoy.blog.dao.AphorismDao;
import com.dicksoy.blog.po.Aphorism;
import com.dicksoy.blog.service.AphorismService;

@Service
public class AphorismServiceImpl extends ServiceImpl<AphorismDao, Aphorism> implements AphorismService {
	
	@Override
	public Aphorism selectOneRandom() {
		return baseMapper.selectOneRandom();
	}

}

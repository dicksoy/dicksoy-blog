package com.dicksoy.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dicksoy.blog.dao.ResourcesDao;
import com.dicksoy.blog.dto.ResourcesDto;
import com.dicksoy.blog.po.Resources;
import com.dicksoy.blog.service.ResourcesService;
import com.dicksoy.blog.vo.ResourcesVo;

@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesDao, Resources> implements ResourcesService {
	
	@Override
	public List<ResourcesVo> loadUserResource(ResourcesDto resources) {
		return baseMapper.loadPetResources(resources);
	}

}

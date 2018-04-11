package com.dicksoy.blog.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.dicksoy.blog.dto.ResourcesDto;
import com.dicksoy.blog.po.Resources;
import com.dicksoy.blog.vo.ResourcesVo;

public interface ResourcesService extends IService<Resources> {

	List<ResourcesVo> loadUserResource(ResourcesDto resources);

}

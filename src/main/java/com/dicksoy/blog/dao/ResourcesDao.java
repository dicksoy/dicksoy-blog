package com.dicksoy.blog.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dicksoy.blog.dto.ResourcesDto;
import com.dicksoy.blog.po.Resources;
import com.dicksoy.blog.vo.ResourcesVo;

public interface ResourcesDao extends BaseMapper<Resources> {

	List<ResourcesVo> loadPetResources(ResourcesDto resources);

}

package com.dicksoy.blog.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dicksoy.blog.dao.ArticleDao;
import com.dicksoy.blog.po.Article;
import com.dicksoy.blog.service.ArticleService;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

}

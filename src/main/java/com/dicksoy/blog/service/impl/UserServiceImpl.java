package com.dicksoy.blog.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dicksoy.blog.dao.UserDao;
import com.dicksoy.blog.po.User;
import com.dicksoy.blog.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService  {

}

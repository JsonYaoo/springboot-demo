package com.jsonyao.cs.service.impl;

import com.jsonyao.cs.entity.User;
import com.jsonyao.cs.mapper.UserMapper;
import com.jsonyao.cs.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserSerivce {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}

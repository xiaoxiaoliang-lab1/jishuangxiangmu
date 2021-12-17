package com.haogu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haogu.entity.User;
import com.haogu.mapper.UserMapper;
import com.haogu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @Override
    public User findUserForLogin(String userName, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        queryWrapper.eq("password",password);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }
}

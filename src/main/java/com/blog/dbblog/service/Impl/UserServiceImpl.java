package com.blog.dbblog.service.Impl;

import com.blog.dbblog.entity.User;
import com.blog.dbblog.mapper.UserMapper;
import com.blog.dbblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务实现层
 *
 * @author wuxi
 * @create 2023-08-16
 *
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
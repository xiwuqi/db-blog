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
        List<User> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.delete(id);
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }

    @Override
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        User user = userMapper.findByUsername(userName);
        return user;
    }

}
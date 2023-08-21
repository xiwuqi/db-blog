package com.blog.dbblog.service;

import com.blog.dbblog.entity.User;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-16
 */

public interface UserService {

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    void createUser(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 更新上次登录时间
     * @param userId
     */
    void updateLoginTime(Integer userId);

}


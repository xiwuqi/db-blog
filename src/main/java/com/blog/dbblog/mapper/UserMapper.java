package com.blog.dbblog.mapper;

import com.blog.dbblog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxi
 * @create 2023-08-16
 */

@Repository
public interface UserMapper {

    /**
     * 查询全部用户信息
     *
     * @return
     */
    List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 根据用户id查找
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    User findByUsername(String userName);
}
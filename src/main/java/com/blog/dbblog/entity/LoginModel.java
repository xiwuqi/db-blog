package com.blog.dbblog.entity;

import lombok.Data;

/**
 * 博客用户密码
 *
 * @author wuxi
 * @create 2023-08-20
 */

@Data
public class LoginModel {

    /**
     * username: admin
     * password: 123456
     */

    private String username;
    private String password;
}

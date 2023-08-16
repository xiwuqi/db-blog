package com.blog.dbblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blog.dbblog.mapper")
public class DbBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbBlogApplication.class, args);
    }

}

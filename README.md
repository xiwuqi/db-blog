# db-blog
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/xiwuqi/external-css@main/loading.css">
    </head>
    <body>
        <div class="spinner"></div>
    </body>
</html>

<p align="center">
    <img src="https://img.shields.io/badge/JDK-1.8+-orange">
    <img src="https://img.shields.io/badge/SpringBoot-2.5.5.RELEASE-654EA3">
    <img src="https://img.shields.io/badge/MyBatis-2.1.3-red">
    <img src="https://img.shields.io/badge/Vue-2.6.10-brightgreen">
    <img src="https://img.shields.io/badge/Redis-7.0.8-blue">
    <img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fxiwuqi%2Fdb-blog&count_bg=%23F7BA0B&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false">
</p>


## 简介

前后端分离的博客后台管理项目。 后端使用Java+SpringBoot+MyBatis+MySQL+Log4j+shiro前端使用Vue+Axios+Element UI+项目整体难度简单，部署简单，界面友好，代码结构清晰，很适合初学者学习和练习。

自用博客，长期维护，欢迎勘误。此项目本是学习过程中的产物，参考了许多优秀的教程和项目，后面会新增博客前台UI的设计。

## 环境介绍

| 名称      | 描述                                     |
| --------- | ---------------------------------------- |
| Java版本  | JDK 1.8.0                                |
| IDE工具   | IntelliJ IDEA 2022.2.3(Ultimate Edition) |
| 构建工具  | Maven 3.8.1                              |
| Web服务器 | SpringBoot内嵌的Tomcat                   |
| 数据库    | MySQL 8.0.32                             |

## 后端

1. 核心框架：[Spring Boot](https://github.com/spring-projects/spring-boot)
2. 安全框架：[shiro](https://github.com/apache/shiro)
3. Token 认证：[shiro](https://github.com/apache/shiro)
4. 持久层框架：[MyBatis](https://github.com/mybatis/spring-boot-starter)
5. 分页插件：[PageHelper](https://github.com/pagehelper/Mybatis-PageHelper)
6. NoSQL缓存：[Redis](https://github.com/redis/redis)
7. 定时任务：`@Scheduled`注解
8. UserAgent 解析：[user-agent-utils](https://github.com/HaraldWalker/user-agent-utils)
9. AOP切面开发注解：[aspectjweaver](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver)
10. 邮件服务：[MailUtil](https://mvnrepository.com/artifact/com.sun.mail)
11. 开源日志记录工具：[logging-log4j2](https://github.com/apache/logging-log4j2)
12. 文件上传

## 快速开始

1. 创建 MySQL 数据库`db_blog`，并运行`db_blog.sql`初始化表数据
2. 修改配置信息`dbblog/src/main/resources/application.yml`
3. 安装 Redis 并启动
4. 启动后端 SpringBoot 服务
5. 在`db-blog_vue`目录下执行`npm install`安装依赖
6. 在`db-blog_vue`目录下执行`npm run dev`启动前后台页面

## 注意事项

- 本人使用的 MySQL 版本为 8.0.32

- 数据库中默认用户名密码为`admin`，`123456`，注意由于前端设置了角色控制，只有被置入`valid_map`中的用户才被允许登录,具体看前端的`validate.js`文件

- 注意修改

  ```text
  application.yml
  ```

  的配置信息

  - Redis 若没有密码，留空即可

## 项目截图

![image-2023243082817521113322](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-2023243082817521113322.png)

![image-20230828175234944](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175234944.png)

![image-2023082817908905335019](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-2023082817533501442119.png)

![image-20230828175503465](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175503465.png)

![image-2023032532532828175530507](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-2023032532532828175530507.png)

![image-20230361742828175551801](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230361742828175551801.png)

![image-20230828175609507](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175609507.png)

![image-20230828175644746](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175644746.png)

![image-20230828175702989](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175702989.png)

![image-20230828175721315](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175721315.png)

![image-20230828175743058](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175743058.png)

![image-20230828175757195](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/image-20230828175757195.png)



## 数据库结构

![db_blog](https://cdn.staticaly.com/gh/xiwuqi/image-hosting@master/uPic/db_blog.png)

## 联系方式

我的博客地址：[梧席的小站](http://wuster.store/)，欢迎大家来踩。

我的联系方式，欢迎联系我：

- 邮箱：`qiyuewuxi@yeah.net`

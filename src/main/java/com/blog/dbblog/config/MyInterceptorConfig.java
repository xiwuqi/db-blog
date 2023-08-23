package com.blog.dbblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 这个是访问图片拦截的
 *
 * @author wuxi
 * @create 2023-08-23
 **/
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("src/main/resources/uploadFile/articles/**")//前端url访问的路径，若有访问前缀，在访问时添加即可，这里不需添加。
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/resources/uploadFile/articles/");//映射的服务器存放图片目录。
    }
}

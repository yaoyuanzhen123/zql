package com.yyz.config;

//使用 @EnableWebMvc 注解，需要以编程（手动建类建方法）的方式指定视图文件相关配置；
//使用 @EnableAutoConfiguration 注解，会读取 application的properties或yml 文件中的配置。

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *    静态资源路径指定
 *    create user Aiden
 *    date 2018/11/8
 *
 * */
@Configuration
@EnableAutoConfiguration
public class StaticConfig extends WebMvcConfigurerAdapter {//继承于spring.1.5.x版本WebMvcConfigurerAdapter    2.x.x.版本需继承WebMvcConfigurer

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/"+"/image/");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/"+"/static/");
    }
}

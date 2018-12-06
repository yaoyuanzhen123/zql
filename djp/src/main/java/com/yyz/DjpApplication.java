package com.yyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient      //Client Register   客户端注册
@EnableHystrix             // Open  Switch     开启断路器
public class DjpApplication extends SpringBootServletInitializer {

    @Bean               //注册一个具有容器功能的RestTemplate
    @LoadBalanced       //开启负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DjpApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DjpApplication.class, args);
    }
}

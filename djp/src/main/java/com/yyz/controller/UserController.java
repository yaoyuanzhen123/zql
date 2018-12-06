package com.yyz.controller;

import com.yyz.config.UrlConfig;
import com.yyz.pojo.TSysUser;
import com.yyz.response.ServerResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final Logger logger = Logger.getLogger(getClass());

    //缓存
    @Autowired
    protected RedisTemplate redisTemplate;

    //负载均衡  调用微服务
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/user/queryAllUser",produces = "application/json")
    public Map<String, Object> loginUser(){
        try{
            ServiceInstance serviceInstance = loadBalancerClient.choose(UrlConfig.ZQL_SERVICE);
            String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/queryAllUser2";
            return ServerResponse.success(new RestTemplate().getForObject(url, String.class),10);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.getMessage());
            return ServerResponse.error();
        }
    }

    @RequestMapping(value = "/user/login",produces = "application/json")
    public String login(){

        return "user";
    }

    @RequestMapping(value = "/user/findAllUser",produces = "application/json")
    @ResponseBody
    public Map<String, Object> loginUser2(){
        try{
            List<TSysUser> tSysUserList = restTemplate.getForObject("http://" + UrlConfig.ZQL_SERVICE + "/user/findAllUser", List.class);
            return ServerResponse.success(tSysUserList,tSysUserList.size());
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.getMessage());
            return ServerResponse.error();
        }
    }

}

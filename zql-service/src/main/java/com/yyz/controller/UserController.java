package com.yyz.controller;


import com.yyz.dto.TSysUser;
import com.yyz.repository.EhcacheRepository;
import com.yyz.repository.UserRepository;
import com.yyz.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EhcacheRepository ehcacheRepository;

    @RequestMapping(value = "/user/queryAllUser",produces = "application/json")
    public TSysUser queryAllUser(){
        try{
            List<TSysUser> all = userRepository.findAll();
            return ehcacheRepository.save(all.get(0));
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/user/findAllUser",produces = "application/json")
    public List<TSysUser> queryAllUsers(){
        try{
            return userRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/user/queryAllUser3/{id}",produces = "application/json")
    public TSysUser queryAllUser(@PathVariable("id") Integer id){
        try{
            return ehcacheRepository.selectById(id);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/user/queryAllUser4/{id}",produces = "application/json")
    public TSysUser updateUser(@PathVariable("id") Integer id){
        try{
            TSysUser tSysUser = ehcacheRepository.selectById(id);
            tSysUser.setCreateUser("姚大大");
            tSysUser.setCreateTime(new Date());
            return ehcacheRepository.updateById(tSysUser);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/user/queryAllUser5/{id}",produces = "application/json")
    public String deleteUser(@PathVariable("id") Integer id){
        try{
            return ehcacheRepository.deleteById(id);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/user/queryAllUser2",produces = "application/json")
    public String queryAllUser2(){
       return "Hellow World";
    }

}

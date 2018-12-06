package com.yyz.repository.imp;

import com.yyz.dto.TSysUser;
import com.yyz.repository.EhcacheRepository;
import com.yyz.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/***
 * 注解的区别：
 * 1）@Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调 用方法获取数据，然后把数据添加到缓存中，适用于查找；
 * 2）@CachePut：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用。适用于更新和插入；
 * 3）@CacheEvict：主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除。
 * */

//cacheNames为ehcache.xml的name文件配置名称
@CacheConfig(cacheNames = {"lemonCache"})
@Repository
public class EhcacheRepositoryImpl implements EhcacheRepository {

    private static final Logger logger = LoggerFactory.getLogger(EhcacheRepository.class);

    @Autowired
    private UserRepository userRepository;

    @CachePut(key = "#p0")
    @Override
    public TSysUser save(TSysUser user) {
        TSysUser tSysUser = userRepository.save(user);
        logger.info("新增功能，同步到缓存，直接写入数据库，ID为：" + tSysUser.getId());
        return tSysUser;
    }

    @CachePut(key = "#p0")
    @Override
    public List<TSysUser> queryAll(List<TSysUser> tSysUserList) {
        List<TSysUser> userList = new ArrayList<TSysUser>();
        tSysUserList.stream().forEach( p ->{
            userList.add(userRepository.save(p));
        });
        logger.info("新增功能，同步到缓存，直接写入数据库，大小：" + userList.size());
        return userList;
    }


    @Cacheable(key = "#p0")
    @Override
    public TSysUser selectById(Integer id) {
        logger.info("查询功能，缓存未找到，直接读取数据库，ID为：" + id);
        return userRepository.findOne(id);
    }



    @CachePut(key = "#p0")
    @Override
    public TSysUser updateById(TSysUser user) {
        logger.info("更新功能，更新缓存，直接更新数据库，ID为：" + user.getId());
        return userRepository.save(user);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Integer id) {
        logger.info("删除功能，删除缓存，直接删除数据库数据，ID为：" + id);
        userRepository.delete(id);
        return "删除成功";
    }
}

package com.yyz.repository;

import com.yyz.vo.VSysUser;
import org.springframework.cache.Cache;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class TestCache {

    @Resource
    private CacheManager cacheManager;

    @Test
    public void cacheTest() {
        // 显示所有的Cache空间
        System.out.println(StringUtils.join(cacheManager.getCacheNames(), ","));
        Cache cache = cacheManager.getCache("lemonCache");
        cache.put("key", "123");
        VSysUser sysUser = VSysUser.builder().id(1).userName("jack").sex("boy").accountNumber("bob").build();
        VSysUser sysUser2 = VSysUser.builder().id(2).userName("jack").sex("boy").accountNumber("bob").build();
        List<VSysUser> vSysUserList = new ArrayList<VSysUser>();
        vSysUserList.add(sysUser);
        vSysUserList.add(sysUser2);
        cache.put("list",vSysUserList);
        System.out.println("缓存成功");
        String res = cache.get("key", String.class);
        List<VSysUser> res2 = cache.get("list", List.class);
        System.out.println(res+"..."+res2.size()+"..."+res2.get(0).getId()+"..."+res2.get(1).getId());
        cache.clear();
        System.out.println(res+":::....");
    }

}

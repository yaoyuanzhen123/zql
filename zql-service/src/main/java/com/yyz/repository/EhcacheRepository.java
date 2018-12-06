package com.yyz.repository;

import com.yyz.dto.TSysUser;

import java.util.List;

public interface EhcacheRepository {
    /**
     * 增加用户
     * @param user 用户
     * @return 增加后的用户
     */
    TSysUser save(TSysUser user);



    /**
     * 查询用户
     * @param id 主键
     * @return 用户
     */
    TSysUser selectById(Integer id);

    /**
     * 查询所有用户
     * @param  List<TSysUser> tSysUserList
     * @return List
     */
    List<TSysUser> queryAll(List<TSysUser> tSysUserList);

    /**
     * 更新用户
     * @param user 更新的用户
     * @return 用户
     */
    TSysUser updateById(TSysUser user);

    /**
     * 删除用户
     * @param id 主键
     * @return 删除状态
     */
    String deleteById(Integer id);
}

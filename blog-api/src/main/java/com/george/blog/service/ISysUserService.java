package com.george.blog.service;

import com.george.blog.pojo.SysUserPO;

/**
 * @description 系统用户Service接口
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface ISysUserService {
    /**
     * @description 查询用户信息
     * @date 2021.01.06
     * @author linzhuangze
     * @param userId
     * @return
     */
    SysUserPO findSysUserById(Long userId);
}

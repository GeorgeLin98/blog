package com.george.blog.service.impl;

import com.george.blog.mapper.SysUserMapper;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description 系统用户Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserPO findSysUserById(Long userId) {
        SysUserPO sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            sysUser = new SysUserPO();
            sysUser.setNickname("匿名");
        }
        return sysUser;
    }
}

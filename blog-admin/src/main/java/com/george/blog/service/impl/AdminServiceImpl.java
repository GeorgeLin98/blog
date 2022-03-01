package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.AdminMapper;
import com.george.blog.pojo.AdminPO;
import com.george.blog.service.IAdminService;
import com.george.blog.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DESCRIPTION 后台用户service实现类
 * @DATE 2022.02.28
 * @AUTHOR LINZHUANZGE
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private AdminMapper adminMapper;

    public AdminPO findAdminByUserName(String username){
        LambdaQueryWrapper<AdminPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdminPO::getUsername,username).last("limit 1");
        AdminPO adminUser = adminMapper.selectOne(queryWrapper);
        return adminUser;
    }

}

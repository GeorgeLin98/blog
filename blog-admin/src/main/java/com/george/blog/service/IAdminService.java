package com.george.blog.service;

import com.george.blog.pojo.AdminPO;

/**
 * DESCRIPTION 后台用户service接口
 * @DATE 2022.02.28
 * @AUTHOR LINZHUANZGE
 */
public interface IAdminService {
    /**
     * @DESCRIPTION 根据用户名查询用户
     * @date 2022.02.28
     * @author linzhuangze
     * @param username
     * @return
     */
    AdminPO findAdminByUserName(String username);
}

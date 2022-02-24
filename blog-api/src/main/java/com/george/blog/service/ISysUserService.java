package com.george.blog.service;

import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.pojo.UserVO;

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

    /**
     * @description 查询用户登录帐号和密码
     * @date 2021.01.08
     * @author linzhuangze
     * @param account
     * @param pwd
     * @return
     */
    SysUserPO findUser(String account, String pwd);

    /**
     * @description 根据token获取用户信息
     * @date 2021.01.08
     * @author linzhuangze
     * @param token
     * @return
     */
    ResultVO getUserInfoByToken(String token);

    /**
     * @decsription 新增用户
     * @date 2021.01.08
     * @author linzhuangze
     * @param sysUser
     */
    void save(SysUserPO sysUser);

    /**
     * @description 查询帐号是否重复
     * @author linzhuangze
     * @date 2021.01.08
     * @param account
     * @return
     */
    SysUserPO findUserByAccount(String account);

    /**
     * @description 查询用户信息
     * @param id
     * @return
     */
    UserVO findUserVoById(Long id);
}

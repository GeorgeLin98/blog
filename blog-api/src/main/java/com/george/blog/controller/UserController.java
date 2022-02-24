package com.george.blog.controller;

import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 用户Controller
 * @author linzhuangze
 * @date 2022-01-08-13:21
 */
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * @decsription 根据token获取用户信息
     * @date 2021.01.08
     * @author linzhuangze
     * @param token
     * @return
     */
    @GetMapping("currentUser")
    public ResultVO currentUser(@RequestHeader("Authorization") String token){
        return sysUserService.getUserInfoByToken(token);
    }

}

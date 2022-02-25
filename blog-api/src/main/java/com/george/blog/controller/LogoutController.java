package com.george.blog.controller;

import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 登出controller
 * @author georgeLin
 * @date 2022-01-08-14:06
 */
@RestController
@RequestMapping("logout")
public class LogoutController {
    @Autowired
    private ILoginService loginService;

    /**
     * @decsription 登出
     * @date 2021.01.08
     * @author linzhuangze
     * @param token
     * @return
     */
    @GetMapping
    public ResultVO logout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}

package com.george.blog.controller;

import com.george.blog.pojo.LoginDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * @description 登录controller
 * @author georgeLin
 * @date 2022-01-08-13:22
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * @description 登录
     * @date 2021.01.08
     * @author linzhuangze
     * @param loginDTO
     * @return
     * @throws NoSuchAlgorithmException
     */
    @PostMapping
    public ResultVO login(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException {
        return loginService.login(loginDTO);
    }
}

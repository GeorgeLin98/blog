package com.george.blog.controller;

import com.george.blog.pojo.LoginDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 注册Controller
 * @author georgeLin
 * @date 2022-01-08-14:17
 */
@RestController
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private ILoginService loginService;

    /**
     * @description 注册接口
     * @author linzhuangze
     * @date 2022.02.25
     * @param loginDTO
     * @return
     */
    @PostMapping
    public ResultVO register(@RequestBody LoginDTO loginDTO){
        return loginService.register(loginDTO);
    }
}

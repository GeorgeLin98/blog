package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 登录DTO
 * @author georgeLin
 * @date 2022-01-08-13:24
 */
@Data
public class LoginDTO {
    /**
     * 帐号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
}

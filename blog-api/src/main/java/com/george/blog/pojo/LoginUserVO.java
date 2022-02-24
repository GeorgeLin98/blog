package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 登录用户返回VO
 * @author georgeLin
 * @date 2022-01-08-14:02
 */
@Data
public class LoginUserVO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 帐号
     */
    private String account;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
}

package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 用户VO
 * @author georgeLin
 * @date 2022-01-11-21:45
 */
@Data
public class UserVO {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 主键id
     */
    private Long id;
}

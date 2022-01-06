package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 系统用户PO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
@TableName(value = "sys_user",keepGlobalPrefix = true)
public class SysUserPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 帐号
     */
    private String account;
    /**
     * 是否管理员
     */
    private Integer admin;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建时间
     */
    private Long createDate;
    /**
     * 是否删除
     */
    private Integer deleted;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 最后登录时间
     */
    private Long lastLogin;
    /**
     * 手机号码
     */
    private String mobilePhoneNumber;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码盐值
     */
    private String salt;
    /**
     * 用户状态
     */
    private String status;
}

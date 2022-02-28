package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * DESCRIPTION 后台用户PO
 * @DATE 2022.02.28
 * @AUTHOR LINZHUANZGE
 */
@Data
public class AdminPO {
    //用户主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //用户
    private String username;
    //密码
    private String password;
}

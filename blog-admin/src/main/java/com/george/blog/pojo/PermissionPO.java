package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 权限PO
 * @author georgeLin
 * @date 2022-02-27-22:18
 */
@Data
@TableName(value = "permission" ,keepGlobalPrefix = true)
public class PermissionPO {
    //权限主键id
    @TableId(type = IdType.AUTO)
    private Long id;
    //权限名称
    private String name;
    //权限路径
    private String path;
    //权限描述
    private String description;
}

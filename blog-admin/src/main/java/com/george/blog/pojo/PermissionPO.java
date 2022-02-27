package com.george.blog.pojo;

/**
 * @description 权限PO
 * @author georgeLin
 * @date 2022-02-27-22:18
 */
@Data
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

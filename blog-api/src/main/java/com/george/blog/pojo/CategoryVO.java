package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 分类VO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
public class CategoryVO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 标签名字
     */
    private String categoryName;
}

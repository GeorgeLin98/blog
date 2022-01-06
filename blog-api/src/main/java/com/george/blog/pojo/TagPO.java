package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 文章标签PO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
public class TagPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标签图片
     */
    private String avatar;
    /**
     * 标签名
     */
    private String tagName;
}

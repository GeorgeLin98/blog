package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 标签VO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
public class TagVO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标签名
     */
    private String tagName;
}

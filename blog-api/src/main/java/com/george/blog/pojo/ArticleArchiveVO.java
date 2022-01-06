package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 文章归档VO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
public class ArticleArchiveVO {
    /**
     * 年
     */
    private Integer year;
    /**
     * 月
     */
    private Integer month;
    /**
     * 归档数量
     */
    private Integer count;
}

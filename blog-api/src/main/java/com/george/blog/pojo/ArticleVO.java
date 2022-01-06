package com.george.blog.pojo;

import lombok.Data;

import java.util.List;

/**
 * @description 文章VO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
public class ArticleVO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 评论数
     */
    private int commentCounts;
    /**
     * 查看量
     */
    private int viewCounts;
    /**
     * 是否置顶
     */
    private int weight;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章内容
     */
    private ArticleBodyVO body;
    /**
     * 标签
     */
    private List<TagVO> tags;
    /**
     * 分类
     */
    private List<CategoryVO> categorys;
}

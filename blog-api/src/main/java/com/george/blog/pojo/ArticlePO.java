package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.george.blog.util.ConstantUtil;
import lombok.Data;

/**
 * @description 文章PO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
@TableName(value = "article",keepGlobalPrefix = true)
public class ArticlePO {
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
     * 阅读数
     */
    private int viewCounts;
    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    /**
     * 类别id
     */
    private Long categoryId;
    /**
     * 是否置顶
     */
    private int weight = ConstantUtil.ARTICLE_COMMON;
    /**
     * 创建时间
     */
    private Long createDate;
}

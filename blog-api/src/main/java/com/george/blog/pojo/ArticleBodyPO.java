package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 文章内容PO
 * @author georgeLin
 * @date 2022-01-08-14:44
 */
@Data
@TableName(value = "article_body",keepGlobalPrefix = true)
public class ArticleBodyPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章html内容
     */
    private String contentHtml;
    /**
     * 文章id
     */
    private Long articleId;
}

package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 评论PO
 * @author georgeLin
 * @date 2022-01-11-21:34
 */
@Data
@TableName(value = "comment",keepGlobalPrefix = true)
public class CommentPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 文章评论内容
     */
    private String content;
    /**
     * 文章评论创建时间
     */
    private Long createDate;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 评论人id
     */
    private Long authorId;
    /**
     * 评论父id
     */
    private Long parentId;
    /**
     * 父评论的评论人id
     */
    private Long toUid;
    /**
     * 评论等级：1-父评论，2-子评论
     */
    private Integer level;
}

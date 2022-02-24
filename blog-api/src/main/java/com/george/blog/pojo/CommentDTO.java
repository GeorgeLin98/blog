package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 评论DTO
 * @author georgeLin
 * @date 2022-01-17-21:44
 */
@Data
public class CommentDTO {
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 评论内容
     */
    private String content;
    /**
     *  父评论id
     */
    private Long parent;
    /**
     *  父评论的评论人id
     */
    private Long toUserId;
}

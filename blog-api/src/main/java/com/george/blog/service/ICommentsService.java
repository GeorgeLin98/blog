package com.george.blog.service;

import com.george.blog.pojo.CommentDTO;
import com.george.blog.pojo.ResultVO;

/**
 * @description 文章评论Service接口
 * @author georgeLin
 * @date 2022-01-11-21:38
 */
public interface ICommentsService {
    /**
     * @description 查找评论列表
     * @param articleId
     * @return
     */
    ResultVO commentsByArticleId(Long articleId);

    /**
     * @description  文章评论
     * @date 2021.01.17
     * @author linzhuangze
     * @param commentDTO
     * @return
     */
    ResultVO comment(CommentDTO commentDTO);
}

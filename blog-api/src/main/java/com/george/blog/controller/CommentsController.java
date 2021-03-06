package com.george.blog.controller;

import com.george.blog.pojo.CommentDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description 文章评论Controller
 * @author georgeLin
 * @date 2022-01-11-21:37
 */
@RestController
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private ICommentsService commentsService;

    /**
     * @description 查找评论列表
     * @param articleId
     * @return
     */
    @GetMapping("article/{id}")
    public ResultVO comments(@PathVariable("id") Long articleId){
        return commentsService.commentsByArticleId(articleId);

    }

    /**
     * @description 评论文章
     * @author linzhuangze
     * @date 2022.02.25
     * @param commentDTO
     * @return
     */
    @PostMapping("create/change")
    public ResultVO comment(@RequestBody CommentDTO commentDTO){
        return commentsService.comment(commentDTO);
    }
}

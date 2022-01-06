package com.george.blog.controller;

import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.IArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 文章Controller层
 * @date 2021.01.06
 * @author linzhuangze
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    private IArticleService articleService;


    public ResultVO articles(@RequestBody PageDTO pageDTO){
        List<ArticleVO> articleVOList = articleService.listArticlePage(pageDTO);
        return ResultVO.success(articleVOList);
    }
}

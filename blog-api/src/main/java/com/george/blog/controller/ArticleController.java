package com.george.blog.controller;

import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.IArticleService;
import com.george.blog.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private IArticleService articleService;

    /**
     * @description 查询文章列表
     * @date 2021.01.06
     * @author linzhuangze
     * @param pageDTO
     * @return
     */
    @PostMapping
    public ResultVO articles(@RequestBody PageDTO pageDTO){
        List<ArticleVO> articleVOList = articleService.listArticlePage(pageDTO);
        return ResultVO.success(articleVOList);
    }

    /**
     * @description 查询最热文章
     * @date 2021.01.06
     * @author linzhuangze
     * @return
     */
    @PostMapping("hot")
    public ResultVO hotArticle(){
        return articleService.hotArticle(ConstantUtil.HOT_ARTICLE_SIZE);
    }

    /**
     * @description 查询最新文章
     * @date 2021.01.06
     * @author linzhuangze
     * @return
     */
    @PostMapping("new")
    public ResultVO newArticles(){
        return articleService.newArticles(ConstantUtil.NEW_ARTICLE_SIZE);
    }

    @PostMapping("listArchives")
    public ResultVO listArchives(){
        return articleService.listArchives();
    }
}

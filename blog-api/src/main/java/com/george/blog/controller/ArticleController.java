package com.george.blog.controller;

import com.george.blog.pojo.ArticleDTO;
import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.IArticleService;
import com.george.blog.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @description 查询文章接口
     * @date 2022.02.25
     * @author linzhuangze
     * @return
     */
    @PostMapping("listArchives")
    public ResultVO listArchives(){
        return articleService.listArchives();
    }

    /**
     * @description 查询文章详情接口
     * @date 2022.02.25
     * @author linzhuangze
     * @param id
     * @return
     */
    @PostMapping("view/{id}")
    public ResultVO findArticleById(@PathVariable("id") Long id) {
        ArticleVO articleVo = articleService.findArticleById(id);
        return ResultVO.success(articleVo);
    }

    /**
     * @description 发布文章
     * @date 2022.02.25
     * @author linzhuangze
     * @param articleDTO
     * @return
     */
    @PostMapping("publish")
    public ResultVO publish(@RequestBody ArticleDTO articleDTO){
        ArticleVO articleVO = articleService.publish(articleDTO);
        return ResultVO.success(articleDTO);
    }
}

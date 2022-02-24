package com.george.blog.service;

import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.ResultVO;

import java.util.List;

/**
 * @description 文章service层接口
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface IArticleService {
    /**
     * @description 列表查询文章
     * @date 2021.01.06
     * @author linzhuangze
     * @return
     */
    List<ArticleVO> listArticlePage(PageDTO pageDTO);

    /**
     * @description 最热文章
     * @date 2021.01.06
     * @author linzhuangze
     * @param limit
     * @return
     */
    ResultVO hotArticle(int limit);
    /**
     * @description 最新文章
     * @date 2021.01.06
     * @author linzhuangze
     * @param limit
     * @return
     */
    ResultVO newArticles(int limit);
    /**
     * @description 归档列表
     * @date 2021.01.06
     * @author linzhuangze
     * @return
     */
    ResultVO listArchives();

    /**
     * @description 文章详情
     * @author linzhuangze
     * @date 2022.01.10
     * @param id
     * @return
     */
    ArticleVO findArticleById(Long id);

}

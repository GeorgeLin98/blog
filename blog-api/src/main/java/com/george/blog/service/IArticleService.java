package com.george.blog.service;

import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;

import java.util.List;

/**
 * @description 文章service层接口
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface IArticleService {
    /**
     * @description 列表查询文章
     * @return
     */
    List<ArticleVO> listArticlePage(PageDTO pageDTO);
}

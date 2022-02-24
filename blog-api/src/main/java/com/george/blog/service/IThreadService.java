package com.george.blog.service;

import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.ArticlePO;

/**
 * @description 线程sevice接口
 * @author georgeLin
 * @date 2022-01-11-21:29
 */
public interface IThreadService {
    /**
     * @description 更新阅读数
     * @date 2021.01.11
     * @author linzhuangze
     * @param articleMapper
     * @param article
     */
    void updateViewCount(ArticleMapper articleMapper, ArticlePO article);
}


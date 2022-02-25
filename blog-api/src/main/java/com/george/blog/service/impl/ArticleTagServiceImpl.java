package com.george.blog.service.impl;

import com.george.blog.mapper.ArticleTagMapper;
import com.george.blog.pojo.ArticleTagPO;
import com.george.blog.service.IArticleTagService;

import javax.annotation.Resource;

/**
 * @description 文章标签关联service实现类
 * @author georgeLin
 * @date 2022-02-25-23:23
 */
public class ArticleTagServiceImpl implements IArticleTagService {
    @Resource
    ArticleTagMapper articleTagMapper;

    @Override
    public void insert(ArticleTagPO po) {
        articleTagMapper.insert(po);
    }
}

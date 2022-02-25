package com.george.blog.service;

import com.george.blog.pojo.ArticleTagPO;

/**
 * @description 文章标签关联service接口
 * @author georgeLin
 * @date 2022-02-25-23:22
 */
public interface IArticleTagService {
    /**
     * @description 新增文章标签po
     * @date 2022.02.25
     * @author linzhuangze
     * @param po
     */
    void insert(ArticleTagPO po);
}

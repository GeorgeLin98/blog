package com.george.blog.service;

import com.george.blog.pojo.ArticleTagPO;

import java.util.List;

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

    /**
     * @description 查询所属标签的文章
     * @date 2022.02.26
     * @author linzhuangze
     * @param tagId
     * @return
     */
    List<ArticleTagPO> selectList(Long tagId);

}

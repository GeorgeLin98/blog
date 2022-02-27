package com.george.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.blog.pojo.ArticleArchiveVO;
import com.george.blog.pojo.ArticlePO;

import java.util.List;

/**
 * @description 文章dao层
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface ArticleMapper extends BaseMapper<ArticlePO> {
    /**
     * @description 查询文章归档信息
     * @date 2021.01.06
     * @author linzhuangze
     * @return
     */
    List<ArticleArchiveVO> listArchives();

    /**
     * @description 查询文章列表
     * @date 2022.02.27
     * @author linzhuangze
     * @param page
     * @param categoryId
     * @param tagId
     * @param year
     * @param month
     * @return
     */
    IPage<ArticlePO> listArticle(Page<ArticlePO> page, Long categoryId, Long tagId, String year, String month);
}

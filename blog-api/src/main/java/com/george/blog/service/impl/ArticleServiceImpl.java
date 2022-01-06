package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.ArticlePO;
import com.george.blog.pojo.ArticleVO;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.pojo.TagVO;
import com.george.blog.service.IArticleService;
import com.george.blog.service.ISysUserService;
import com.george.blog.service.ITagService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/**
 * @description 文章Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ITagService tagService;

    @Override
    public List<ArticleVO> listArticlePage(PageDTO pageDTO) {
        QueryWrapper<ArticlePO> queryWrapper = new QueryWrapper<>();
        Page<ArticlePO> page = new Page<>(pageDTO.getPage(),pageDTO.getPageSize());
        Page<ArticlePO> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleVO> articleVoList = copyList(articlePage.getRecords(),true,false,true);
        return articleVoList;
    }


    private List<ArticleVO> copyList(List<ArticlePO> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleVO> articleVoList = new ArrayList<>();
        for (ArticlePO article : records) {
            ArticleVO articleVO = copy(article,isAuthor,isBody,isTags);
            articleVoList.add(articleVO);
        }
        return articleVoList;
    }

    private ArticleVO copy(ArticlePO article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleVO articleVo = new ArticleVO();
        BeanUtils.copyProperties(article, articleVo);
        if (isAuthor) {
            SysUserPO sysUser = sysUserService.findSysUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTags){
            List<TagVO> tags = tagService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }
}

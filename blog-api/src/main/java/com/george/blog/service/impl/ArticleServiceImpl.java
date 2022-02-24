package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.blog.mapper.ArticleBodyMapper;
import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.*;
import com.george.blog.service.*;
import com.george.blog.util.ConstantUtil;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @description 文章Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IArticleBodyService articleBodyService;
    @Autowired
    private IThreadService threadService;

    @Override
    public List<ArticleVO> listArticlePage(PageDTO pageDTO) {
        QueryWrapper<ArticlePO> queryWrapper = new QueryWrapper<>();
        Page<ArticlePO> page = new Page<>(pageDTO.getPage(),pageDTO.getPageSize());
        Page<ArticlePO> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleVO> articleVoList = copyList(articlePage.getRecords(),true,true);
        return articleVoList;
    }

    @Override
    public ResultVO hotArticle(int limit) {
        LambdaQueryWrapper<ArticlePO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(ArticlePO::getViewCounts);
        queryWrapper.select(ArticlePO::getId,ArticlePO::getTitle);
        queryWrapper.last("limit " + limit);
        List<ArticlePO> articles = articleMapper.selectList(queryWrapper);
        return ResultVO.success(copyList(articles,false,false));
    }

    @Override
    public ResultVO newArticles(int limit) {
        LambdaQueryWrapper<ArticlePO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(ArticlePO::getCreateDate);
        queryWrapper.select(ArticlePO::getId,ArticlePO::getTitle);
        queryWrapper.last("limit "+limit);
        //select id,title from article order by create_date desc limit 5
        List<ArticlePO> articles = articleMapper.selectList(queryWrapper);
        return ResultVO.success(copyList(articles,false,false));
    }

    @Override
    public ResultVO listArchives() {
        List<ArticleArchiveVO> archivesList = articleMapper.listArchives();
        return ResultVO.success(archivesList);
    }

    @Override
    public ArticleVO findArticleById(Long id) {
        ArticlePO article = articleMapper.selectById(id);
        threadService.updateViewCount(articleMapper,article);
        return copy(article,true,true,true,true);
    }

    /**
     * @description 循环转换文章VO
     * @author linzhuangze
     * @date 2021.01.06
     * @param records
     * @param isAuthor
     * @param isBody
     * @param isTags
     * @return
     */
    private List<ArticleVO> copyList(List<ArticlePO> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleVO> articleVoList = new ArrayList<>();
        for (ArticlePO article : records) {
            ArticleVO articleVO = copy(article,isTags,isAuthor,isBody,false);
            articleVoList.add(articleVO);
        }
        return articleVoList;
    }

    private List<ArticleVO> copyList(List<ArticlePO> records,boolean isAuthor,boolean isTags) {
        List<ArticleVO> articleVoList = new ArrayList<>();
        for (ArticlePO article : records) {
            ArticleVO articleVO = copy(article,isTags,isAuthor,false,false);
            articleVoList.add(articleVO);
        }
        return articleVoList;
    }

    private List<ArticleVO> copyList(List<ArticlePO> records, boolean isTag, boolean isAuthor,boolean isBody,boolean isCategory) {
        List<ArticleVO> articleVoList = new ArrayList<>();
        for (ArticlePO record : records) {
            articleVoList.add(copy(record,isTag,isAuthor,isBody,isCategory));
        }
        return articleVoList;
    }

    /**
     * @description 转换文章VO
     * @date 2021.01.06
     * @author linzhuangze
     * @param article
     * @param isAuthor
     * @param isBody
     * @param isTags
     * @return
     */
    private ArticleVO copy(ArticlePO article,boolean isTags,boolean isAuthor,boolean isBody,boolean isCategory){
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        //查询文章作者信息
        if (isAuthor) {
            SysUserPO sysUser = sysUserService.findSysUserById(article.getAuthorId());
            articleVO.setAuthor(sysUser.getNickname());
        }
        //转换时间
        articleVO.setCreateDate(new DateTime(article.getCreateDate()).toString(ConstantUtil.DATE_TIME_FORMAT));
        //查询文章标签信息
        if (isTags){
            List<TagVO> tags = tagService.findTagsByArticleId(article.getId());
            articleVO.setTags(tags);
        }
        //查询文章正文
        if (isBody){
            ArticleBodyVO articleBodyVO = articleBodyService.findArticleBody(article.getId());
            articleVO.setBody(articleBodyVO);
        }
        //查询文章分类
        if (isCategory){
            CategoryVO categoryVO = categoryService.findCategoryById(article.getCategoryId());
            articleVO.setCategory(categoryVO);
        }
        return articleVO;
    }
}

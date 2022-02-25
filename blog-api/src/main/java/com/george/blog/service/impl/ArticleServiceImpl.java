package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.blog.mapper.ArticleBodyMapper;
import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.*;
import com.george.blog.service.*;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.UserThreadLocal;
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
    @Resource
    private IArticleTagService articleTagService;

    @Override
    public List<ArticleVO> listArticlePage(PageDTO pageDTO) {
        //分页查询 article数据库表
        Page<ArticlePO> page = new Page<>(pageDTO.getPage(),pageDTO.getPageSize());
        LambdaQueryWrapper<ArticlePO> queryWrapper = new LambdaQueryWrapper<>();
        if (pageDTO.getCategoryId() != null) {
            queryWrapper.eq(ArticlePO::getCategoryId,pageDTO.getCategoryId());
        }
        List<Long> articleIdList = new ArrayList<>();
        if (pageDTO.getTagId() != null){
            List<ArticleTagPO> articleTags = articleTagService.selectList(pageDTO.getTagId());
            for (ArticleTagPO articleTag : articleTags) {
                articleIdList.add(articleTag.getArticleId());
            }
            if (articleIdList.size() > 0){
                queryWrapper.in(ArticlePO::getId,articleIdList);
            }
        }
        //是否置顶进行排序
        //order by create_date desc
        queryWrapper.orderByDesc(ArticlePO::getWeight,ArticlePO::getCreateDate);
        Page<ArticlePO> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticlePO> records = articlePage.getRecords();
        //能直接返回吗？ 很明显不能
        List<ArticleVO> articleVoList = copyList(records,true,true);
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

    @Override
    public ArticleVO publish(ArticleDTO articleDTO) {
        //返回登录用户信息
        SysUserPO sysUserPO = UserThreadLocal.get();
        //新增文章
        ArticlePO article = new ArticlePO();
        article.setAuthorId(sysUserPO.getId());
        article.setCategoryId(articleDTO.getCategory().getId());
        article.setCreateDate(System.currentTimeMillis());
        article.setCommentCounts(0);
        article.setSummary(articleDTO.getSummary());
        article.setTitle(articleDTO.getTitle());
        article.setViewCounts(0);
        article.setWeight(ConstantUtil.ARTICLE_COMMON);
        article.setBodyId(-1L);
        this.articleMapper.insert(article);
        //新增关联标签
        List<TagVO> tags = articleDTO.getTags();
        if (tags != null) {
            for (TagVO tag : tags) {
                ArticleTagPO articleTag = new ArticleTagPO();
                articleTag.setArticleId(article.getId());
                articleTag.setTagId(tag.getId());
                articleTagService.insert(articleTag);
            }
        }
        //新增关联正文
        ArticleBodyPO articleBody = new ArticleBodyPO();
        articleBody.setContent(articleDTO.getBody().getContent());
        articleBody.setContentHtml(articleDTO.getBody().getContentHtml());
        articleBody.setArticleId(article.getId());
        articleBodyService.insert(articleBody);
        //更新关联的正文
        article.setBodyId(articleBody.getId());
        articleMapper.updateById(article);
        //返回新增文章
        ArticleVO articleVo = new ArticleVO();
        articleVo.setId(article.getId());
        return articleVo;
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

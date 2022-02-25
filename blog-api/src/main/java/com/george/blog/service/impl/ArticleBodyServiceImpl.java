package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.ArticleBodyMapper;
import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.ArticleBodyPO;
import com.george.blog.pojo.ArticleBodyVO;
import com.george.blog.service.IArticleBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description  文章正文service实现类
 * @author georgeLin
 * @date 2022-01-11-21:11
 */
@Service
public class ArticleBodyServiceImpl implements IArticleBodyService {
    @Resource
    private ArticleBodyMapper articleBodyMapper;

    @Override
    public ArticleBodyVO findArticleBody(Long articleId) {
        LambdaQueryWrapper<ArticleBodyPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleBodyPO::getArticleId,articleId);
        ArticleBodyPO articleBody = articleBodyMapper.selectOne(queryWrapper);
        ArticleBodyVO articleBodyVo = new ArticleBodyVO();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }

    @Override
    public void insert(ArticleBodyPO articleBodyPO) {
        articleBodyMapper.insert(articleBodyPO);
    }
}

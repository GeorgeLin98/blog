package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.ArticleMapper;
import com.george.blog.pojo.ArticlePO;
import com.george.blog.service.IThreadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description 线程池Service实现类
 * @author georgeLin
 * @date 2022-01-11-21:25
 */
@Component
public class ThreadServiceImpl implements IThreadService {
    /**
     * 使用该方法的都是异步使用
     * @param articleMapper
     * @param article
     */
    @Async("taskExecutor")
    @Override
    public void updateViewCount(ArticleMapper articleMapper, ArticlePO article){
        ArticlePO articleUpdate = new ArticlePO();
        articleUpdate.setViewCounts(article.getViewCounts() + 1);
        LambdaQueryWrapper<ArticlePO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticlePO::getId,article.getId());
        queryWrapper.eq(ArticlePO::getViewCounts,article.getViewCounts());
        articleMapper.update(articleUpdate,queryWrapper);
    }
}

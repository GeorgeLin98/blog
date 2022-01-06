package com.george.blog.service;

import com.george.blog.pojo.TagVO;

import java.util.List;

/**
 * @description 文章Service接口
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface ITagService {
    List<TagVO> findTagsByArticleId(Long id);
}

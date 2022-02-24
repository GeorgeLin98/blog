package com.george.blog.service;

import com.george.blog.pojo.CategoryVO;
import com.george.blog.pojo.ResultVO;

/**
 * @description 文章标签service接口层
 * @author georgeLin
 * @date 2022-01-10-22:04
 */
public interface ICategoryService {
    /**
     * @description 查找标签
     * @author linzhuangze
     * @date 2021.01.10
     * @param id
     * @return
     */
    CategoryVO findCategoryById(Long id);

    /**
     * @description 查询所有标签
     * @return
     */
    ResultVO findAll();
}

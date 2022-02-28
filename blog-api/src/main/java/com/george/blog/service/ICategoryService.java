package com.george.blog.service;

import com.george.blog.pojo.CategoryPO;
import com.george.blog.pojo.CategoryVO;
import com.george.blog.pojo.ResultVO;

import java.util.List;

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

    /**
     * @description 查询所有的文章分类
     * @date 2022.02.26
     * @author linzhuangze
     * @return
     */
    List<CategoryPO> findAllDetail();

    /**
     * @description  通过文章分类查询该分类
     * @date 2022.02.26
     * @author linzhuangze
     * @param id
     * @return
     */
    CategoryVO categoriesDetailById(Long id);
}

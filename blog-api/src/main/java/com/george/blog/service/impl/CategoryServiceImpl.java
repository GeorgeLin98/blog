package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.CategoryMapper;
import com.george.blog.pojo.CategoryPO;
import com.george.blog.pojo.CategoryVO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author georgeLin
 * @date 2022-01-10-22:09
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVO findCategoryById(Long id) {
        CategoryPO category = categoryMapper.selectById(id);
        CategoryVO categoryVo = new CategoryVO();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }

    public CategoryVO copy(CategoryPO category){
        CategoryVO categoryVo = new CategoryVO();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
    public List<CategoryVO> copyList(List<CategoryPO> categoryList){
        List<CategoryVO> categoryVoList = new ArrayList<>();
        for (CategoryPO category : categoryList) {
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }

    @Override
    public ResultVO findAll() {
        List<CategoryPO> categories = this.categoryMapper.selectList(new LambdaQueryWrapper<>());
        return ResultVO.success(copyList(categories));
    }

    @Override
    public List<CategoryPO> findAllDetail() {
        List<CategoryPO> categories = categoryMapper.selectList(new LambdaQueryWrapper<>());
        return categories;
    }

    @Override
    public CategoryVO categoriesDetailById(Long id) {
        CategoryPO category = categoryMapper.selectById(id);
        CategoryVO categoryVo = copy(category);
        return categoryVo;
    }
}

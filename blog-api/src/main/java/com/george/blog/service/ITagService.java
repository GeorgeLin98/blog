package com.george.blog.service;

import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.TagPO;
import com.george.blog.pojo.TagVO;

import java.util.List;

/**
 * @description 文章Service接口
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface ITagService {
    /**
     * @description 查询标签信息
     * @date 2021.01.06
     * @author linzhuangze
     * @param id
     * @return
     */
    List<TagVO> findTagsByArticleId(Long id);
    /**
     * @description 查询最热标签
     * @date 2021.01.06
     * @author linzhuangze
     * @param limit
     * @return
     */
    List<TagVO> hot(int limit);

    /**
     * @description 查询所有标签
     * @date 2022.02.25
     * @author linzhuangze
     * @return
     */
    List<TagPO> findAll();

    /**
     * @Description 查询所有的标签
     * @date 2022.02.26
     * @author linzhuangze
     * @return
     */
    List<TagPO> findAllDetail();

    /**
     * @description 查询文章标签下的标签
     * @date 2022.02.26
     * @author linzhuangze
     * @param id
     * @return
     */
    TagPO findDetailById(Long id);
}

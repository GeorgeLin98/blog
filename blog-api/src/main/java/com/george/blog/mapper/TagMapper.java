package com.george.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.blog.pojo.TagPO;

import java.util.List;

/**
 * @description 文章标签dao层
 * @date 2021.01.06
 * @author linzhuangze
 */
public interface TagMapper extends BaseMapper<TagPO> {
    /**
     * @description 查询标签信息
     * @date 2021.01.06
     * @author linzhuangze
     * @param articleId
     * @return
     */
    List<TagPO> findTagsByArticleId(Long articleId);
    /**
     * @description 查询最热标签
     * @date 2021.01.06
     * @author linzhuangze
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);
    /**
     * @description 查询标签信息
     * @date 2021.01.06
     * @author linzhuangze
     * @param hotsTagIds
     * @return
     */
    List<TagPO> findTagsByTagIds(List<Long> hotsTagIds);
}

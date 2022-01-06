package com.george.blog.service.impl;

import com.george.blog.mapper.TagMapper;
import com.george.blog.pojo.TagPO;
import com.george.blog.pojo.TagVO;
import com.george.blog.service.ITagService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description 文章标签Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
public class TagServiceImpl implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVO> findTagsByArticleId(Long id) {
        List<TagPO> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public List<TagVO> hot(int limit) {
        List<Long> hotsTagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(hotsTagIds)){
            return Collections.emptyList();
        }
        List<TagPO> tagList = tagMapper.findTagsByTagIds(hotsTagIds);
        return copyList(tagList);
    }

    /**
     * @description 转换标签VO
     * @date 2021.01.06
     * @author linzhuangze
     * @param tag
     * @return
     */
    public TagVO copy(TagPO tag){
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag,tagVO);
        return tagVO;
    }

    /**
     * @description 循环转换标签VO
     * @author linzhuangze
     * @date 2021.01.06
     * @param tagList
     * @return
     */
    public List<TagVO> copyList(List<TagPO> tagList){
        List<TagVO> tagVoList = new ArrayList<>();
        for (TagPO tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }
}

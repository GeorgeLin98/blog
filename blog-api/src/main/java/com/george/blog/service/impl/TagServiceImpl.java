package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.TagMapper;
import com.george.blog.pojo.TagPO;
import com.george.blog.pojo.TagVO;
import com.george.blog.service.ITagService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description 文章标签Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
@Service
public class TagServiceImpl implements ITagService {

    @Resource
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

    @Override
    public List<TagPO> findAll() {
        List<TagPO> tags = this.tagMapper.selectList(new LambdaQueryWrapper<>());
        return tags;
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

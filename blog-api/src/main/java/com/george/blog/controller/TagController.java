package com.george.blog.controller;

import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.TagVO;
import com.george.blog.service.ITagService;
import com.george.blog.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {
    @Autowired
    private ITagService tagsService;

    /**
     * @description 查询最热标签
     * @author linzhuanzge
     * @date 2021.01.06
     * @return
     */
    @GetMapping("/hot")
    public ResultVO listHotTags() {
        List<TagVO> tagVoList = tagsService.hot(ConstantUtil.HOT_TAG_SIZE);
        return ResultVO.success(tagVoList);
    }
}

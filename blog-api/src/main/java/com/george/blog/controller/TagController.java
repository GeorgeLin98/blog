package com.george.blog.controller;

import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.TagVO;
import com.george.blog.service.ITagService;
import com.george.blog.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description  标签controller
 * @author  linzhuangze
 * @date 2022.02.25
 */
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

    /**
     * @description 查询所有标签
     * @date 2022.02.25
     * @author linzhuangze
     * @return
     */
    @GetMapping
    public ResultVO findAll(){
        return ResultVO.success(tagsService.findAll());
    }

    /**
     * @DESCRIPTION 查询所有的标签
     * @date 2022.02.26
     * @author linzhuangze
     * @return
     */
    @GetMapping("detail")
    public ResultVO findAllDetail(){
        return ResultVO.success(tagsService.findAllDetail());
    }

    /**
     * @description 查询文章标签下的标签
     * @dete 2022.02.26
     * @author linzhuangze
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public ResultVO findDetailById(@PathVariable("id") Long id){
        return ResultVO.success(tagsService.findDetailById(id));
    }
}

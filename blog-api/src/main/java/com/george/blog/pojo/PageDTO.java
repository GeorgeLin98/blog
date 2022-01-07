package com.george.blog.pojo;

import com.george.blog.util.ConstantUtil;
import lombok.Data;

/**
 * @description 分页DTO
 * @date 2021.01.06
 * @author  linzhuangze
 */
@Data
public class PageDTO {
    /**
     * 文章页数
     */
    private Integer pageSize = ConstantUtil.ARTICLE_PAGE_SIZE;
    /**
     * 文章初始页码
     */
    private Integer page = ConstantUtil.ARTICLE_PAGE;
}

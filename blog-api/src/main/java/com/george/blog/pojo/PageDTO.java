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
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 标签id
     */
    private Long tagId;
    /**
     * 年
     */
    private String year;
    /**
     * 月
     */
    private String month;

    public String getMonth() {
        if (this.month != null && this.month.length() == 1){
            return "0"+this.month;
        }
        return this.month;
    }
}

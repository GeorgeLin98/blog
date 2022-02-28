package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 分页DTO
 * @date 2022.02.27
 * @author  linzhuangze
 */
@Data
public class PageDTO {
    /**
     * 页码
     */
    private Integer currentPage;
    /**
     * 页数
     */
    private Integer pageSize;
    /**
     * 查询参数
     */
    private String queryString;

}

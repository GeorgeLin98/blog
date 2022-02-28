package com.george.blog.pojo;

import java.util.List;

/**
 * @description 分页返回DTO
 * @author georgeLin
 * @date 2022-02-27-22:32
 */
@Data
public class PageResultDTO<T>   {
    /**
     * 分页列表
     */
    private List<T> list;
    /**
     * 分页总数
     */
    private Long total;
}

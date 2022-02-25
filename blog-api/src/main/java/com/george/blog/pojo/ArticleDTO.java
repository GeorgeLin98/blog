package com.george.blog.pojo;

import lombok.Data;

import java.util.List;

/**
 * @DESCRIPTION 文章dto
 * @author georgeLin
 * @date 2022-02-25-23:02
 */
@Data
public class ArticleDTO {
    //id
    private Long id;
    //文章内容dto
    private ArticleBodyDTO body;
    //分类
    private CategoryVO category;
    //概要
    private String summary;
    //标签
    private List<TagVO> tags;
    //标题
    private String title;
}

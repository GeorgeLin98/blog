package com.george.blog.pojo;

import lombok.Data;

/**
 * @description 文章内容dto
 * @author georgeLin
 * @date 2022-02-25-23:03
 */
@Data
public class ArticleBodyDTO {
    //内容
    private String content;
    //html内容
    private String contentHtml;
}

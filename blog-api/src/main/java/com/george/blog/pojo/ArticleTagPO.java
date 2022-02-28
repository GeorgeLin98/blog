package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 文章标签关联PO
 * @author georgeLin
 * @date 2022-02-25-23:15
 */
@Data
@TableName(value = "article_tag",keepGlobalPrefix = true)
public class ArticleTagPO {
    //主键id
    private Long id;
    //文章id
    private Long articleId;
    //标签id
    private Long tagId;
}

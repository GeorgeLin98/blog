package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 分类PO
 * @author georgeLin
 * @date 2022-01-08-14:46
 */
@Data
@TableName(value = "category",keepGlobalPrefix = true)
public class CategoryPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 分类头像
     */
    private String avatar;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类描述
     */
    private String description;
}

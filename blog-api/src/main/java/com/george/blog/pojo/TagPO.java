package com.george.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description 文章标签PO
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
@TableName(value = "tag",keepGlobalPrefix = true)
public class TagPO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标签图片
     */
    private String avatar;
    /**
     * 标签名
     */
    private String tagName;
}

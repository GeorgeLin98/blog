package com.george.blog.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @description 评论VO
 * @author georgeLin
 * @date 2022-01-11-21:43
 */
@Data
public class CommentVO {
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 评论人
     */
    private UserVO author;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 子评论List
     */
    private List<CommentVO> childrens;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 评论等级
     */
    private Integer level;
    /**
     * 父评论的评论人id
     */
    private UserVO toUser;
}

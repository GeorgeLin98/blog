package com.george.blog.util;

/**
 * @description 常量工具类
 * @author  linzhuangze
 * @date 2021.01.06
 */
public class ConstantUtil {
    /**
     * 置顶文章
     */
    public static final int ARTICLE_TOP = 1;
    /**
     * 取消置顶文章
     */
    public static final int ARTICLE_COMMON = 0;
    /**
     * 成功响应
     */
    public static final boolean RESPONSE_SUCCESS = true;
    /**
     * 不成功响应
     */
    public static final boolean RESPONSE_FAIL = false;
    /**
     * 文章初始页码
     */
    public static final int ARTICLE_PAGE = 1;
    /**
     * 文章页数
     */
    public static final int ARTICLE_PAGE_SIZE = 10;
    /**
     * 时间格式化字符串
     */
    public static final String DATE_TIME_FORMAT= "yyyy-MM-dd HH:mm";
    /**
     * 最热文章数量
     */
    public static final int HOT_ARTICLE_SIZE = 5;
    /**
     * 最热标签数量
     */
    public static final int HOT_TAG_SIZE = 6;
    /**
     * 最新文章数量
     */
    public static final int NEW_ARTICLE_SIZE = 5;
    /**
     * jwt过期时间：24小时
     */
    public static final int JWT_EXPIRE_TIME = 24 * 60 * 60 * 1000;
    /**
     * 用户密码加密盐值
     */
    public static final String  USER_PASSWORD_SALT  = "georgeLin";
    /**
     * redis-key:存放用户信息
     */
    public static final String  REDIS_USER_JWT_KEY  = "TOKEN_";
    /**
     * 响应头信息JSON类型
     */
    public static final String  RESPONSE_HEADER_JSON  = "application/json;charset=utf-8";
    /**
     * 一级评论
     */
    public static final Integer COMMENT_FIRST_LEVEL = 1;
    /**
     * 点符号
     */
    public static final String STRING_POINT = ".";
}

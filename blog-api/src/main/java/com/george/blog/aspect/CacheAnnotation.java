package com.george.blog.aspect;

import java.lang.annotation.*;

/**
 * @author georgeLin
 * @date 2022-02-27-21:49
 */

/**
 * @description 缓存注解
 * @date 2022.02.27
 * @author  linzhuangze
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheAnnotation {
    //过期时间
    long expire() default 1 * 60 * 1000;

    //缓存名字key
    String name() default "";
}


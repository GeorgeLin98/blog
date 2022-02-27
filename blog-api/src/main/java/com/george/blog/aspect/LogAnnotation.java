package com.george.blog.aspect;

import java.lang.annotation.*;

/**
 * @description 日志注解
 * @author georgeLin
 * @date 2022-02-25-23:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    //模块名称
    String module() default "";
    //操作名称
    String operation() default "";
}

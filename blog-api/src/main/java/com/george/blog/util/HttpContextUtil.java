package com.george.blog.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @DESCRIPTION http工具类
 * @author georgeLin
 * @date 2022-02-25-23:52
 */
public class HttpContextUtil {
    /**
     * @description 获取HttpServletRequest请求
     * @date 2022.02.25
     * @author linzhuangze
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

}

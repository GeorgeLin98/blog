package com.george.blog.util;

import com.george.blog.pojo.SysUserPO;

/**
 * @description 线程本地变量工具类
 * @author georgeLin
 * @date 2022-01-08-14:33
 */
public class UserThreadLocal {
    private UserThreadLocal(){}

    private static final ThreadLocal<SysUserPO> LOCAL = new ThreadLocal<>();

    public static void put(SysUserPO sysUser){
        LOCAL.set(sysUser);
    }
    public static SysUserPO get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}

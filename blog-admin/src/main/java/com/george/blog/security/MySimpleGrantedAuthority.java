package com.george.blog.security;

import org.springframework.security.core.GrantedAuthority;
/**
 * @description
 * @date 2022.02.28
 * @author linzhuanzge
 */
public class MySimpleGrantedAuthority implements GrantedAuthority {

    private String authority;

    private String path;

    public String getPath() {
        return path;
    }

    public MySimpleGrantedAuthority(){}

    public MySimpleGrantedAuthority(String authority){
        this.authority = authority;
    }

    public MySimpleGrantedAuthority(String authority,String path){
        this.authority = authority;
        this.path = path;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}

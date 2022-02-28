package com.george.blog.config;

/**
 * @description 权限管理配置
 * @author georgeLin
 * @date 2022-02-27-22:33
 */
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
    /**
     * 密码加密器
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}

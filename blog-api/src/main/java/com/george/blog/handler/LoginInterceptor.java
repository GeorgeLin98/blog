package com.george.blog.handler;

import com.alibaba.fastjson.JSON;
import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.service.ILoginService;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.MsgCodeDesc;
import com.george.blog.util.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 登录拦截器
 * @author georgeLin
 * @date 2022-01-08-14:27
 */
@Component
@Slf4j
public class LoginInterceptor  implements HandlerInterceptor {
    @Autowired
    private ILoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if (token == null){
            ResultVO result = ResultVO.fail(MsgCodeDesc.NO_LOGIN.getCode(), MsgCodeDesc.NO_LOGIN.getMsg());
            response.setContentType(ConstantUtil.RESPONSE_HEADER_JSON);
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUserPO sysUser = loginService.checkToken(token);
        if (sysUser == null){
            ResultVO result = ResultVO.fail(MsgCodeDesc.NO_LOGIN.getCode(), MsgCodeDesc.NO_LOGIN.getMsg());
            response.setContentType(ConstantUtil.RESPONSE_HEADER_JSON);
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登录验证成功，放行
        //我希望在controller中 直接获取用户的信息 怎么获取?
        UserThreadLocal.put(sysUser);
        //是登录状态，放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}

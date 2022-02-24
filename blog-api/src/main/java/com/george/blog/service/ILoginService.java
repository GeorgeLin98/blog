package com.george.blog.service;

import com.george.blog.pojo.LoginDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.SysUserPO;

import java.security.NoSuchAlgorithmException;

/**
 * @decsription 登录SERVICE接口
 * @author georgeLin
 * @date 2022-01-08-13:24
 */
public interface ILoginService {
    /**
     * @description 登录
     * @date 2021.01.08
     * @author linzhuangze
     * @param loginDTO
     * @return
     */
    ResultVO login(LoginDTO loginDTO) throws NoSuchAlgorithmException;

    /**
     * @description 登出
     * @date 2021.01.08
     * @author linzhuangze
     * @param token
     * @return
     */
    ResultVO logout(String token);

    /**
     * @description 注册
     * @date 2021.01.08
     * @author linzhuangze
     * @param loginDTO
     * @return
     */
    ResultVO register(LoginDTO loginDTO);

    /**
     * @description 检查token
     * @date 2021.01.08
     * @author linzhuangze
     * @param token
     * @return
     */
    SysUserPO checkToken(String token);
}

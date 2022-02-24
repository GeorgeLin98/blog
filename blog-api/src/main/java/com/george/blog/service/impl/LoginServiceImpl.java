package com.george.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.george.blog.pojo.LoginDTO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.service.ILoginService;
import com.george.blog.service.ISysUserService;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.JWTUtil;
import com.george.blog.util.MsgCodeDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description 登录service实现类
 * @author georgeLin
 * @date 2022-01-08-13:28
 */
@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ResultVO login(LoginDTO loginDTO) throws NoSuchAlgorithmException {
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return ResultVO.fail(MsgCodeDesc.PARAMS_ERROR.getCode(),MsgCodeDesc.PARAMS_ERROR.getMsg());
        }
        String pwd = DigestUtils.md5DigestAsHex((password + ConstantUtil.USER_PASSWORD_SALT).getBytes());
        SysUserPO sysUser = sysUserService.findUser(account, pwd);
        if (sysUser == null){
            return ResultVO.fail(MsgCodeDesc.ACCOUNT_PWD_NOT_EXIST.getCode(),MsgCodeDesc.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        //登录成功，使用JWT生成token，返回token和redis中
        String token = JWTUtil.createToken(sysUser.getId());
        redisTemplate.opsForValue().set(ConstantUtil.REDIS_USER_JWT_KEY+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return ResultVO.success(token);
    }

    @Override
    public ResultVO logout(String token) {
        redisTemplate.delete(ConstantUtil.REDIS_USER_JWT_KEY+token);
        return ResultVO.success(null);
    }

    @Override
    public ResultVO register(LoginDTO loginDTO) {
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();
        String nickname = loginDTO.getNickname();
        if (StringUtils.isBlank(account)
                || StringUtils.isBlank(password)
                || StringUtils.isBlank(nickname)
        ){
            return ResultVO.fail(MsgCodeDesc.PARAMS_ERROR.getCode(),MsgCodeDesc.PARAMS_ERROR.getMsg());
        }
        SysUserPO sysUser = this.sysUserService.findUserByAccount(account);
        if (sysUser != null){
            return ResultVO.fail(MsgCodeDesc.ACCOUNT_EXIST.getCode(),MsgCodeDesc.ACCOUNT_EXIST.getMsg());
        }
        sysUser = new SysUserPO();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5DigestAsHex((password + ConstantUtil.USER_PASSWORD_SALT).getBytes()));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        sysUser.setAdmin(1); //1 为true
        sysUser.setDeleted(0); // 0 为false
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");
        this.sysUserService.save(sysUser);
        //token
        String token = JWTUtil.createToken(sysUser.getId());
        redisTemplate.opsForValue().set(ConstantUtil.REDIS_USER_JWT_KEY+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return ResultVO.success(token);
    }

    public SysUserPO checkToken(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtil.checkToken(token);
        if (stringObjectMap == null){
            return null;
        }
        String userJson = redisTemplate.opsForValue().get(ConstantUtil.REDIS_USER_JWT_KEY + token);
        if (StringUtils.isBlank(userJson)){
            return null;
        }
        SysUserPO sysUser = JSON.parseObject(userJson, SysUserPO.class);
        return sysUser;
    }
}

package com.george.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.george.blog.mapper.SysUserMapper;
import com.george.blog.pojo.LoginUserVO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.pojo.SysUserPO;
import com.george.blog.pojo.UserVO;
import com.george.blog.service.ISysUserService;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.JWTUtil;
import com.george.blog.util.MsgCodeDesc;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description 系统用户Service实现类
 * @date 2021.01.06
 * @author linzhuangze
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public SysUserPO findSysUserById(Long userId) {
        SysUserPO sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            sysUser = new SysUserPO();
            sysUser.setNickname("匿名");
        }
        return sysUser;
    }

    @Override
    public SysUserPO findUser(String account, String pwd) {
        LambdaQueryWrapper<SysUserPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserPO::getAccount,account);
        queryWrapper.eq(SysUserPO::getPassword,pwd);
        queryWrapper.select(SysUserPO::getId,SysUserPO::getAccount,SysUserPO::getAvatar,SysUserPO::getNickname);
        queryWrapper.last("limit 1");
        SysUserPO sysUser = sysUserMapper.selectOne(queryWrapper);
        return sysUser;
    }

    @Override
    public ResultVO getUserInfoByToken(String token) {
        Map<String, Object> map = JWTUtil.checkToken(token);
        if (map == null){
            return ResultVO.fail(MsgCodeDesc.NO_LOGIN.getCode(),MsgCodeDesc.NO_LOGIN.getMsg());
        }
        String userJson = redisTemplate.opsForValue().get(ConstantUtil.REDIS_USER_JWT_KEY + token);
        if (StringUtils.isBlank(userJson)){
            return ResultVO.fail(MsgCodeDesc.NO_LOGIN.getCode(),MsgCodeDesc.NO_LOGIN.getMsg());
        }
        SysUserPO sysUser = JSON.parseObject(userJson, SysUserPO.class);
        LoginUserVO loginUserVo = new LoginUserVO();
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setAvatar(sysUser.getAvatar());
        loginUserVo.setId(sysUser.getId());
        loginUserVo.setNickname(sysUser.getNickname());
        return ResultVO.success(loginUserVo);
    }

    @Override
    public void save(SysUserPO sysUser) {
        //注意 默认生成的id 是分布式id 采用了雪花算法
        this.sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUserPO findUserByAccount(String account) {
        LambdaQueryWrapper<SysUserPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserPO::getAccount,account);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public UserVO findUserVoById(Long id) {
        SysUserPO sysUser = sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUserPO();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/logo.b3a48c0.png");
            sysUser.setNickname("匿名");
        }
        UserVO userVo = new UserVO();
        userVo.setAvatar(sysUser.getAvatar());
        userVo.setNickname(sysUser.getNickname());
        userVo.setId(sysUser.getId());
        return userVo;
    }
}

package com.george.blog.util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description JWT工具类
 * @date 2021.01.07
 * @author linzhuangze
 */
public class JWTUtil {
    /**
     * jwt加密秘钥
     */
    private static final String SECRET_KEY = "0123456789george";

    /**
     * @description 创造JWT
     * @date 2021.01.08
     * @author linzhuangze
     * @param userId
     * @return
     */
    public static String createToken(Long userId){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置加密算法和加密的秘钥
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                //设置载荷信信息
                .addClaims(claims)
                //设置jwt生成时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + ConstantUtil.JWT_EXPIRE_TIME));
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * @description 检查jwt是否合法
     * @date 2021.01.08
     * @author linzhuanzge
     * @param token
     * @return
     */
    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse = Jwts.parser().setSigningKey(SECRET_KEY).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

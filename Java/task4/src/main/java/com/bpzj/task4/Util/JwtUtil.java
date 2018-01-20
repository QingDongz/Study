package com.bpzj.task4.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    /**
     *
     * @param subject 需要加密的信息
     * @param signKey 加密用的秘钥
     * @return 生成的 token 字符串
     */
    public static String getJwtToken(String subject, String signKey) {
        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        JwtBuilder jwtBuilder = Jwts.builder()
                // subject 是需要加密的东西，这里是用户名
                .setSubject(subject)
                // 传入 当前时间，说明签发的时间
                .setIssuedAt(now)
                // 用 signKey 做秘钥，对信息加密
                .signWith(SignatureAlgorithm.HS256, signKey);

        return jwtBuilder.compact();
    }

    /**
     * 解密 cookieValue值
     * @param cookieToken 用户发送的，加密后的 cookie值
     * @param signKey 解密时用的 秘钥
     * @return 解密后的信息
     */
    public static String jwtDecrypt(String cookieToken, String signKey) {

        String message="";
        try{
            message= Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(cookieToken)
                .getBody()
                .getSubject();
        } catch (Exception e){
            // 如果错误，直接把message设置为空字符串。
            message = "";
        }

        return message;
    }


}

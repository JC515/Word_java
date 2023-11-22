/*
package com.demo1.Pojo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    // 私钥
    private static final String SECRET_KEY = "itheima";

    public static void main(String[] args) {
        // 生成token
        String jwtToken = Jwts.builder()
                // 头部
                .setHeaderParam("typ", "JWT")

                // jwt 标注中的申明
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(new Date().getTime() + 10000L))// 过期时间
                .setSubject("xiaomin")// jwt面向的客户
                .setIssuer("JC")// jwt的签发者

                // 公共申明和私有申明
                .claim("user_id", "admin")
                .claim("phone", "18251421000")
                .claim("age", 25)
                .claim("sex", "男")

                // 签证
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())

                .compact();

        System.out.println("生成的 jwt token 如下:" + jwtToken);
    }

    public String createToken(Map<String, Object> claims, String key, long validityPeriod) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + validityPeriod))
                .compact();
    }
}

*/

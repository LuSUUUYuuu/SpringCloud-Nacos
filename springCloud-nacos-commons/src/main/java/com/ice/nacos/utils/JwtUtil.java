package com.ice.nacos.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
public class JwtUtil {
    // 加密秘钥
    private static String secret = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";
    // token有效时长，1天，单位秒
    private static long expire = 60 * 60 * 24;

    /**
     * 生成jwt token
     */
    public static String generateToken(String subject) {
        //当前时间
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.debug("validate token is error ", e);
            return null;
        }
    }

    public static void main(String[] args) {

        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + 60000 * 1000);
        String s = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(1+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, "f4e2e52034348f86b67cde581c0f9eb5")
                .compact();
        System.out.println("=========token: " + s);


        Claims claims = getClaimByToken(s);
        System.out.println(claims);
    }
}

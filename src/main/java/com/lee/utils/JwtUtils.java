package com.lee.utils;

import com.lee.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    public static final String SUBJECT = "xdclass";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周

    //秘钥
    public static final  String APPSECRET = "xd666";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        if(user == null || user.getId() == null || user.getUsername() == null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("username",user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){ }
        return null;

    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("123");
        user.setPassword("123");
        String s = geneJsonWebToken(user);
        System.out.println(s);
        Claims claims = checkJWT(s);
        System.out.println("===================");
        System.out.println(claims.get("id"));
        System.out.println(claims.get("username"));

    }
}

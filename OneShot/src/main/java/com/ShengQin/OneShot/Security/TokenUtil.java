package com.ShengQin.OneShot.Security;
import com.ShengQin.OneShot.Entities.Administrator;
import com.ShengQin.OneShot.Entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author hanmingzhi
 * @date 2022/8/14 18:47
 **/
public class TokenUtil {
    //token到期时间30分钟(根据需求改)
    private static final long EXPIRE_TIME= 30*60*1000;
    //密钥 (随机生成,可以从网上找到随机密钥生成器)
    private static final String TOKEN_SECRET="MD9**+4MG^EG79RV+T?J87AI4NWQVT^&";
    /** 生成token */
    public static String createToken(int id){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    .withClaim("role","user")
                    //存放数据
//                    .withClaim("userName",user.getUserName())
                    .withClaim("id",id)
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {}
        return token;
    }
    /**管理员token生成*/
    public static String createAdminToken(Administrator administrator){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    .withClaim("role","administrator")
                    //存放数据
                    .withClaim("userName",administrator.getAdminName())
                    .withClaim("id",administrator.getId())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {}
        return token;
    }

    /** token验证 */
    public static Boolean checkToken(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("id: " + decodedJWT.getClaim("id").asInt());
            System.out.println("user name: " + decodedJWT.getClaim("userName").asString());
            System.out.println("过期时间：" + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    public static Boolean checkAdminToken(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            /**不是管理员访问管理员内容则返回false*/
            if (!(decodedJWT.getClaim("role").asString()).equals("administrator")) return false;
            System.out.println("认证通过：");
            System.out.println("id: " + decodedJWT.getClaim("id").asInt());
            System.out.println("user name: " + decodedJWT.getClaim("userName").asString());
            System.out.println("过期时间：" + decodedJWT.getExpiresAt());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    public static boolean IdPermissionCheck(String token,int user_id){//验证用户权限，避免操作别人的页面
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        if ((decodedJWT.getClaim("id").asInt()).equals(user_id)) return true;
        else return false;
    }
    public static int getUserIdFromToken(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            return decodedJWT.getClaim("id").asInt();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return 0;
        }
    }
}


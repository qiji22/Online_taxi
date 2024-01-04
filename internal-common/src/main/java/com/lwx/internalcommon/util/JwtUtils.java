package com.lwx.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lwx.internalcommon.dto.TokenResult;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  17:03
 */
public class JwtUtils {

    //
    private static final String SIGN = "CPFlwx!@33#";

    private static final String JWT_KEY_PHONE = "passengerPhone";
    private static final String JWT_KEY_IDENTITY = "identityPhone";

    private static final String JWT_TOKEN_TYPE = "tokenType";

    private static final String JWT_TOKEN_TIME = "tokenTime";


    //生成token
    public static String generatorToken(String passengerPhone ,String identity,String tokenType){
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_PHONE,passengerPhone);
        map.put(JWT_KEY_IDENTITY,identity);
        map.put(JWT_TOKEN_TYPE,tokenType);
        //token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date date = calendar.getTime();
        map.put(JWT_TOKEN_TIME,Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        //整合map
        map.forEach((k,v) ->{
            builder.withClaim(k,v);
        });
        //整合过期时间
//        builder.withExpiresAt(date);

        //生成token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }

    //解析token
    public static TokenResult parseToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY_PHONE).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(phone);
        tokenResult.setIdentity(identity);
        return tokenResult;

    }

/*
 * @description:校验token是否异常
 **/
    public static TokenResult checkToken(String token){
        TokenResult tokenResult =null;

        try {
            tokenResult= JwtUtils.parseToken(token);
        }catch (Exception e){

        }
        return tokenResult;
    }

}

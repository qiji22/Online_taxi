package com.lwx.apipassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.lwx.internalcommon.constant.TokenTypeConstant;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.dto.TokenResult;
import com.lwx.internalcommon.util.JwtUtils;
import com.lwx.internalcommon.util.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-17  14:57
 */
public class JwtInterceptor  implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = true;

        String resutltString ="";

        String token = request.getHeader("Authorization");

        TokenResult tokenResult = JwtUtils.checkToken(token);


        if(tokenResult ==null){
            resutltString = "access token invalid";
            result = false;
        }else {
            //拼接Key
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone,identity, TokenTypeConstant.ACCESS_TOKEN_TYPE);
            //从redis中取出token
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if(StringUtils.isBlank(tokenRedis) || !token.trim().equals(tokenRedis.trim())){
                resutltString = "access token invalid";
                result = false;
            }
        }



        //比较我们传入的token和redis中的token是否相等

        if(!result){
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resutltString)).toString());
        }

        return result;
    }

}

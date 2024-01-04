package com.lwx.apipassenger.service;

import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.constant.TokenTypeConstant;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.dto.TokenResult;
import com.lwx.internalcommon.response.TokenResponse;
import com.lwx.internalcommon.util.JwtUtils;
import com.lwx.internalcommon.util.RedisPrefixUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  13:41
 */
@Service
public class TokenService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult refreshToken(String refreshTokenSrc){
        //解析refreshToken
        TokenResult tokenResult = JwtUtils.checkToken(refreshTokenSrc);
        if(tokenResult ==null){
            return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(),CommonStatusEnum.TOKEN_ERROR.getValue());
        }
        String phone = tokenResult.getPhone();
        String identity = tokenResult.getIdentity();
        //读取redis中的refreshToken
        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(phone, identity, TokenTypeConstant.REFRESH_TOKEN_TYPE);
        String refreshTokenRedis = stringRedisTemplate.opsForValue().get(refreshTokenKey);
        //校验Token
        if(StringUtils.isBlank(refreshTokenRedis) || !refreshTokenSrc.trim().equals(refreshTokenRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(),CommonStatusEnum.TOKEN_ERROR.getValue());
        }
        //生成双Token
        String refreshToken = JwtUtils.generatorToken(phone, identity, TokenTypeConstant.REFRESH_TOKEN_TYPE);
        String accessToken = JwtUtils.generatorToken(phone,identity,TokenTypeConstant.ACCESS_TOKEN_TYPE);

        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(phone,identity,TokenTypeConstant.ACCESS_TOKEN_TYPE);

        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,30, TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31,TimeUnit.DAYS);
//        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,10, TimeUnit.SECONDS);
//        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,60,TimeUnit.SECONDS);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }

}

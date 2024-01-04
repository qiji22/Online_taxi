package com.lwx.apipassenger.service;


import com.lwx.apipassenger.remote.ServicePassengerUserClient;
import com.lwx.apipassenger.remote.ServiceVerificationCodeClient;
import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.constant.IdentityConstant;
import com.lwx.internalcommon.constant.IdentityConstants;
import com.lwx.internalcommon.constant.TokenTypeConstant;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.VerificationCodeDTO;
import com.lwx.internalcommon.response.NumberCodeResponse;
import com.lwx.internalcommon.response.TokenResponse;
import com.lwx.internalcommon.util.JwtUtils;
import com.lwx.internalcommon.util.RedisPrefixUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    @Autowired
    private ServiceVerificationCodeClient serviceVerificationCodeClient;



    @Autowired
    private StringRedisTemplate stringRedisTemplate;





    public ResponseResult generatorCode(String passengerPhone){
        //调用验证码服务，获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code :"+numberCode);

        //key, value ,过期时间
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone, IdentityConstants.PASSENGER_IDENTITY);
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        //通过短信服务商，将对应的验证码发送到手机上， 阿里短信服务，腾讯短信通。。。

        return ResponseResult.success("");
    }


/**
 * @description:校验验证码
 * @author: MR_LWX
 * @date: 2023/8/3 14:58
 * @param: [passengerPhone, verificationCode]
 * @return: com.lwx.internalcommon.dto.ResponseResult
 **/

    public ResponseResult checkCode(String passengerPhone,String verificationCode){
        //根据手机号，去Redis读取验证码
            //生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone,IdentityConstants.PASSENGER_IDENTITY);
            //根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        //校验验证码
        if(StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if(!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        //判断原来是否有用户，并且进行对应的处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrReg(verificationCodeDTO);

        //颁发令牌
        String accessToken = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenTypeConstant.ACCESS_TOKEN_TYPE);

        String refreshToken = JwtUtils.generatorToken(passengerPhone,IdentityConstant.PASSENGER_IDENTITY,TokenTypeConstant.REFRESH_TOKEN_TYPE);


        //将token存到redis中
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone,IdentityConstant.PASSENGER_IDENTITY,TokenTypeConstant.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,30,TimeUnit.DAYS);
//        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,20,TimeUnit.SECONDS);
        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone,IdentityConstant.PASSENGER_IDENTITY,TokenTypeConstant.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31,TimeUnit.DAYS);
//        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,60,TimeUnit.SECONDS);
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }



}

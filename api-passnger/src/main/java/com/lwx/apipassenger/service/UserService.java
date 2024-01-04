package com.lwx.apipassenger.service;

import com.lwx.apipassenger.remote.ServicePassengerUserClient;
import com.lwx.internalcommon.dto.PassengerUser;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.dto.TokenResult;
import com.lwx.internalcommon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  14:56
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult getUserByAccesssToken(String accessToken){
        log.info("accessToken :"+ accessToken);
        //解析accessToken
        TokenResult tokenResult = JwtUtils.checkToken(accessToken);
        //根据手机号查询用户信息
        PassengerUser passengerUser = new PassengerUser();
        String phone = tokenResult.getPhone();
        ResponseResult user = servicePassengerUserClient.getUserByPhone(phone);
        return user;
    }
}

package com.lwx.apipassenger.controller;

import com.lwx.apipassenger.service.TokenService;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  13:38
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){

        String refreshTokenSrc = tokenResponse.getRefreshToken();
        return tokenService.refreshToken(refreshTokenSrc);
    }
}

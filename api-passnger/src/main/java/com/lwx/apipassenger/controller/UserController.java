package com.lwx.apipassenger.controller;

import com.lwx.apipassenger.service.UserService;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  14:54
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request){
        //从http请求中获取accessToken
        String accessToken = request.getHeader("Authorization");
        return userService.getUserByAccesssToken(accessToken);
    }
}

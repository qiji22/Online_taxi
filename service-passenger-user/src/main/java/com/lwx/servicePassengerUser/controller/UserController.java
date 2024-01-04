package com.lwx.servicePassengerUser.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.VerificationCodeDTO;
import com.lwx.servicePassengerUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  15:57
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrReg(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String passengerPhone = verificationCodeDTO.getPassengerPhone();

        return userService.loginOrReg(passengerPhone);
    }

    @GetMapping("/user/{phone}")
    public ResponseResult getUserByPhone(@PathVariable("phone") String phone){

        return userService.getUserByPhone(phone);
    }
}

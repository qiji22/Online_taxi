package com.lwx.aPiDriver.service;


import com.lwx.internalcommon.dto.ResponseResult;


public interface IVerificationCodeService {

    public ResponseResult checkAndsendVerificationCode(String driverPhone);

    public ResponseResult checkCode(String driverPhone , String verificationCode);
}

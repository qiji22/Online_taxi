package com.lwx.aPiDriver.controller;



import com.lwx.aPiDriver.service.IVerificationCodeService;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private IVerificationCodeService iverificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String driverPhone = verificationCodeDTO.getDriverPhone();
        return iverificationCodeService.checkAndsendVerificationCode(driverPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String drivePhone = verificationCodeDTO.getDriverPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();
        return iverificationCodeService.checkCode(drivePhone,verificationCode);
    }

}

package com.lwx.serviceverificationcode.controller;


import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){

        //生成验证码
        // 获取随机数
        double mathRandom = (Math.random()*9+1)*Math.pow(10,size-1);
        int resultInt =(int)mathRandom;
        System.out.println(size+"位数随机验证码："+resultInt);

        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);


    }


}

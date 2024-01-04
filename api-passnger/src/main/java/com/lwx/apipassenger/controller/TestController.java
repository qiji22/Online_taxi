package com.lwx.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/authTest")
    public String authTest(){
        return "hello authTest";
    }

    @GetMapping("/noauthTest")
    public String noauthTest(){
        return "hello noauthTest";
    }
}

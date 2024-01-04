package com.lwx.aPiDriver.controller;

import com.lwx.aPiDriver.service.IPointService;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ApiDriverPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-26  09:00
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private IPointService iPointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody ApiDriverPointDTO apiDriverPointDTO){
        return iPointService.upload(apiDriverPointDTO);
    }

}

package com.lwx.servicemap.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.PointRequest;
import com.lwx.servicemap.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-25  15:52
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private IPointService iPointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody PointRequest pointRequest){
        return iPointService.upload(pointRequest);
    }
}

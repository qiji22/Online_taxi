package com.lwx.servicemap.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TrackResponse;
import com.lwx.servicemap.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  14:46
 */
@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private ITrackService iTrackService;

    @PostMapping("/add")
    public ResponseResult<TrackResponse> add(String tid){
        return iTrackService.add(tid);
    }
}

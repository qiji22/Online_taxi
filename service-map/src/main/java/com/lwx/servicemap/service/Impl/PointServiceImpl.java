package com.lwx.servicemap.service.Impl;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.PointRequest;
import com.lwx.servicemap.remote.PointClient;
import com.lwx.servicemap.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-25  15:58
 */
@Service
public class PointServiceImpl implements IPointService {
    @Autowired
    private PointClient pointClient;

    public ResponseResult upload(PointRequest pointRequest){
        return pointClient.upload(pointRequest);
    }
}

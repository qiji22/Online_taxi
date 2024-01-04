package com.lwx.servicemap.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.DirectionResponse;
import com.lwx.servicemap.remote.MapDirectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-04  11:28
 */
@Service
public class DirectionService {

    @Autowired
    private MapDirectionClient mapDirectionClient;

    public ResponseResult driving(String depLongitude,String depLatitude,String destLongitude,String destLatitude){

        //调用第三方接口
        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);
        return ResponseResult.success(direction);
    }
}

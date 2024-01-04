package com.lwx.servicemap.service.Impl;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TrackResponse;
import com.lwx.servicemap.remote.TrackClient;
import com.lwx.servicemap.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  14:58
 */
@Service
public class TrackServiceImpl implements ITrackService{

    @Autowired
    private TrackClient trackClient;

    public ResponseResult<TrackResponse> add(String tid){
        return trackClient.add(tid);
    }
}

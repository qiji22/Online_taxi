package com.lwx.servicemap.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TrackResponse;

public interface ITrackService {

    public ResponseResult<TrackResponse> add(String tid);

}

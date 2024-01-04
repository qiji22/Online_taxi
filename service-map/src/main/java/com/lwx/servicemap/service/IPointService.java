package com.lwx.servicemap.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.PointRequest;

public interface IPointService {

    public ResponseResult upload(PointRequest pointRequest);
}

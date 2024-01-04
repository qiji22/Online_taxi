package com.lwx.aPiDriver.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ApiDriverPointDTO;

public interface IPointService {

    public ResponseResult upload(ApiDriverPointDTO apiDriverPointDTO);

}

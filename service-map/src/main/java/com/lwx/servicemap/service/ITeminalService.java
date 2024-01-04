package com.lwx.servicemap.service;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;

public interface ITeminalService {

    public ResponseResult<TerminalResponse> add(String name,String desc);

    public ResponseResult aroundsearch(String center,Integer radius);
}

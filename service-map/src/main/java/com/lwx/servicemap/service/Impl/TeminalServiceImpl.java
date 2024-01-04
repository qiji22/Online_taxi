package com.lwx.servicemap.service.Impl;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;
import com.lwx.servicemap.remote.TerminalClient;
import com.lwx.servicemap.service.ITeminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-24  13:38
 */
@Service
public class TeminalServiceImpl implements ITeminalService {

    @Autowired
    private TerminalClient terminalClient;

    public ResponseResult<TerminalResponse> add(String name,String desc){
        return terminalClient.add(name,desc);
    }

    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius){
        return terminalClient.aroundSearch(center,radius);
    }
}

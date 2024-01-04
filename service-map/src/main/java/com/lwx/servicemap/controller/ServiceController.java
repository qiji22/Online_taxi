package com.lwx.servicemap.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.servicemap.service.IServiceFromMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-19  09:15
 */
@RestController
@Api(tags = "服务控制器")
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceFromMapService iServiceFromMapService;

    /*
     * @description:创建服务
     * @return:
     **/
    @PostMapping("/add")
    @ApiOperation(value = "创建服务")
    public ResponseResult add(String name){
        return iServiceFromMapService.add(name);
    }
}

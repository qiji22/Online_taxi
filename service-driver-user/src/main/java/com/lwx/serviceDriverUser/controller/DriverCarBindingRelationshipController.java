package com.lwx.serviceDriverUser.controller;


import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.service.IDriverCarBindingRelationshipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:46
 */
@RestController
@RequestMapping("/driver-car-binding-relationship")
@Api(tags = "司机车辆绑定")
public class DriverCarBindingRelationshipController {

    @Autowired
    private IDriverCarBindingRelationshipService iDriverCarBindingRelationshipService;

    @PostMapping("/bind")
    @ApiOperation(value = "司机车辆绑定")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return iDriverCarBindingRelationshipService.bind(driverCarBindingRelationship);
    }

    @PostMapping("/unbind")
    @ApiOperation(value = "司机车辆解绑")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return iDriverCarBindingRelationshipService.unbind(driverCarBindingRelationship);
    }
}

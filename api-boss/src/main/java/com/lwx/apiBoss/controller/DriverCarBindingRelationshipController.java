package com.lwx.apiBoss.controller;

import com.lwx.apiBoss.service.IDriverCarBindingRelationshipService;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-13  14:07
 */
@RestController
@RequestMapping("/driver-car-binding-relationship")
public class DriverCarBindingRelationshipController {

    @Autowired
    private IDriverCarBindingRelationshipService iDriverCarBindingRelationshipService;

    @PostMapping("/bind")
    @ApiOperation(value = "添加车辆信息")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return iDriverCarBindingRelationshipService.bind(driverCarBindingRelationship);
    }

    @PostMapping("/unbind")
    @ApiOperation(value = "添加车辆信息")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return iDriverCarBindingRelationshipService.unbind(driverCarBindingRelationship);
    }
}

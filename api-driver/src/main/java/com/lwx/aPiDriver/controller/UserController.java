package com.lwx.aPiDriver.controller;

import com.lwx.aPiDriver.service.IUserService;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-06  15:21
 */
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PutMapping("/user")
    @ApiOperation(value = "更新司机信息")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser) {
        return iUserService.updateDriverUser(driverUser);
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增司机信息")
    public ResponseResult addUser(@RequestBody DriverUser driverUser) {
        return iUserService.addUser(driverUser);
    }

    @GetMapping("/user")
    @ApiOperation(value = "查询司机")
    public ResponseResult getUser(@RequestBody DriverUser driverUser){

        return null;
    }

}

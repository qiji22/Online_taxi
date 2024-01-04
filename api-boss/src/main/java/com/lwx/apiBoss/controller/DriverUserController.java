package com.lwx.apiBoss.controller;

import com.lwx.apiBoss.service.ICarService;
import com.lwx.apiBoss.service.IDriverUserService;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-04  10:45
 */
@RestController
public class DriverUserController {
    @Autowired
    private IDriverUserService iDriverUserService;

    @Autowired
    private ICarService iCarService;
    /*
     * @description:添加司机
     * @return:
     **/
    @PostMapping("/driver-user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser) {
        return iDriverUserService.addDriverUser(driverUser);
    }

    @PutMapping("/driver-user")
    @ApiOperation(value = "更新司机信息")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser) {
        return iDriverUserService.updateDriverUser(driverUser);
    }

    @PostMapping("/car")
    @ApiOperation(value = "添加车辆信息")
    public ResponseResult addCar(@RequestBody Car car){
        return iCarService.addCar(car);
    }

}

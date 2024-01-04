package com.lwx.serviceDriverUser.controller;

import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.service.ICarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:25
 */
@RestController
@RequestMapping("/car")
@Api(tags = "车辆信息")
public class CarController {
    @Autowired
    private ICarService iCarService;

    @PostMapping("/addCar")
    @ApiOperation(value = "添加车辆信息")
    public ResponseResult addCar(@RequestBody Car car) {
        return iCarService.addCar(car);
    }

    @GetMapping("/getCarById/{carId}")
    public ResponseResult<Car> getCarById(@PathVariable("carId") Long carId){
        return iCarService.getCarById(carId);
    }
}

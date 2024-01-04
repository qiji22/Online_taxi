package com.lwx.aPiDriver.remote;

import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.DriverUserExistsResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);

    @PostMapping("/user")
    @ApiOperation(value = "添加用户信息")
    public ResponseResult addUser(@RequestBody DriverUser driverUser);

    @GetMapping("/check-driver/{driverPhone}")
    @ApiOperation(value = "检验用户信息")
    public ResponseResult<DriverUserExistsResponse> checkDriver(@PathVariable("driverPhone") String driverPhone);

    @GetMapping("/car/getCarById/{carId}")
    public ResponseResult<Car> getCarById(@PathVariable("carId") Long carId);
}

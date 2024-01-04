package com.lwx.apiBoss.remote;

import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser);

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);

    @RequestMapping(method = RequestMethod.POST,value = "/car/addCar")
    public ResponseResult addCar(@RequestBody Car car);

    @PostMapping("/driver-car-binding-relationship/bind")
    @ApiOperation(value = "司机车辆绑定")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship);

    @PostMapping("/driver-car-binding-relationship/unbind")
    @ApiOperation(value = "司机车辆解绑")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship);

}


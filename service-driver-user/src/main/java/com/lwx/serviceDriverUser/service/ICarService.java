package com.lwx.serviceDriverUser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.ResponseResult;


public interface ICarService extends IService<Car> {

    public ResponseResult addCar(Car car);

    public ResponseResult<Car> getCarById(Long carId);

}

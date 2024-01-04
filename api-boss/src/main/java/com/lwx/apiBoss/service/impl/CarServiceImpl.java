package com.lwx.apiBoss.service.impl;

import com.lwx.apiBoss.remote.ServiceDriverUserClient;
import com.lwx.apiBoss.service.ICarService;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-13  13:44
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addCar(Car car) {
        return serviceDriverUserClient.addCar(car);
    }
}

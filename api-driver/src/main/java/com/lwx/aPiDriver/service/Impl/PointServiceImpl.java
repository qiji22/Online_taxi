package com.lwx.aPiDriver.service.Impl;

import com.lwx.aPiDriver.remote.ServiceDriverUserClient;
import com.lwx.aPiDriver.remote.ServiceMapClient;
import com.lwx.aPiDriver.service.IPointService;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ApiDriverPointDTO;
import com.lwx.internalcommon.request.PointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-26  09:07
 */
@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult upload(ApiDriverPointDTO apiDriverPointDTO) {
        //获取carId
        Long carId = apiDriverPointDTO.getCarId();
        //通过carId获取tid，trid
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);

        if (carById == null) {
            return ResponseResult.fail("");
        }
        Car car = carById.getData();
        if (car == null) {
            return ResponseResult.fail("");
        }
        //调用地图去上传
        PointRequest pointRequest = new PointRequest();
        pointRequest.setTid(car.getTid());
        pointRequest.setTrid(car.getTrid());
        pointRequest.setPoints(apiDriverPointDTO.getPoints());
        ResponseResult upload = serviceMapClient.upload(pointRequest);
        return upload;
    }
}

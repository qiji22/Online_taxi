package com.lwx.serviceDriverUser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.response.TerminalResponse;
import com.lwx.internalcommon.response.TrackResponse;
import com.lwx.serviceDriverUser.mapper.CarMapper;
import com.lwx.serviceDriverUser.remote.ServiceMapClient;
import com.lwx.serviceDriverUser.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:27
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;


    public ResponseResult addCar(Car car) {
        LocalDateTime now = LocalDateTime.now();
        car.setGmtCreate(now);
        carMapper.insert(car);
        //获取此车辆对应的Tid值
        ResponseResult<TerminalResponse> responseResult = serviceMapClient.addTerminal(car.getVehicleNo(),car.getId().toString());
        TerminalResponse data = responseResult.getData();
        car.setTid(data.getTid());
        //获得车辆轨迹
        ResponseResult<TrackResponse> trackResponseResponseResult = serviceMapClient.addTrack(data.getTid());
        TrackResponse trackResponse = trackResponseResponseResult.getData();
        car.setTrid(trackResponse.getTrid());
        car.setTrname(trackResponse.getTrname());

        carMapper.updateById(car);
        return ResponseResult.success("添加车辆信息成功！");
    }

    public ResponseResult<Car> getCarById(Long carId){
        Car car = carMapper.selectById(carId);
        return ResponseResult.success(car);
    }
}

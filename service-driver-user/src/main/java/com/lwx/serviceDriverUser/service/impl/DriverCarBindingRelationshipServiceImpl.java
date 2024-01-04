package com.lwx.serviceDriverUser.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.constant.DriverCarConstants;
import com.lwx.internalcommon.dto.Car;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.mapper.CarMapper;
import com.lwx.serviceDriverUser.mapper.DriverCarBindingRelationshipMapper;
import com.lwx.serviceDriverUser.service.ICarService;
import com.lwx.serviceDriverUser.service.IDriverCarBindingRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:48
 */
@Service
public class DriverCarBindingRelationshipServiceImpl extends ServiceImpl<DriverCarBindingRelationshipMapper, DriverCarBindingRelationship> implements IDriverCarBindingRelationshipService {

    @Autowired
    private DriverCarBindingRelationshipMapper driverCarBindingRelationshipMapper;

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship) {
        //判断，如果参数中的车辆和司机，已经做过绑定，则不允许再次绑定

        List<DriverCarBindingRelationship> driverCarBindingRelationships = driverCarBindingRelationshipMapper.selectList(new LambdaQueryWrapper<DriverCarBindingRelationship>()
                .eq(DriverCarBindingRelationship::getDriverId, driverCarBindingRelationship.getDriverId())
                .eq(DriverCarBindingRelationship::getCarId, driverCarBindingRelationship.getCarId())
                .eq(DriverCarBindingRelationship::getBindState, DriverCarConstants.DRIVER_CAR_BIND));

        if (!driverCarBindingRelationships.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getCode(), CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getValue());
        }
        //司机被绑定
        List<DriverCarBindingRelationship> driverBindingRelationships = driverCarBindingRelationshipMapper.selectList(new LambdaQueryWrapper<DriverCarBindingRelationship>()
                .eq(DriverCarBindingRelationship::getDriverId, driverCarBindingRelationship.getDriverId())
                .eq(DriverCarBindingRelationship::getBindState, DriverCarConstants.DRIVER_CAR_BIND));

        if (!driverBindingRelationships.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_BIND_EXISTS.getCode(), CommonStatusEnum.DRIVER_BIND_EXISTS.getValue());
        }
        //车辆被绑定
        List<DriverCarBindingRelationship> carBindingRelationships = driverCarBindingRelationshipMapper.selectList(new LambdaQueryWrapper<DriverCarBindingRelationship>()
                .eq(DriverCarBindingRelationship::getCarId, driverCarBindingRelationship.getCarId())
                .eq(DriverCarBindingRelationship::getBindState, DriverCarConstants.DRIVER_CAR_BIND));

        if (!carBindingRelationships.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.CAR_BIND_EXISTS.getCode(), CommonStatusEnum.CAR_BIND_EXISTS.getValue());
        }
        LocalDateTime now = LocalDateTime.now();
        driverCarBindingRelationship.setBindingTime(now);
        driverCarBindingRelationship.setBindState(DriverCarConstants.DRIVER_CAR_BIND);
        driverCarBindingRelationshipMapper.insert(driverCarBindingRelationship);
        return ResponseResult.success("添加绑定成功！");
    }


    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship) {
        //判断，如果参数中的车辆和司机，已经做过绑定，则不允许再次绑定

        List<DriverCarBindingRelationship> driverCarBindingRelationships = driverCarBindingRelationshipMapper.selectList(new LambdaQueryWrapper<DriverCarBindingRelationship>()
                .eq(DriverCarBindingRelationship::getDriverId, driverCarBindingRelationship.getDriverId())
                .eq(DriverCarBindingRelationship::getCarId, driverCarBindingRelationship.getCarId())
                .eq(DriverCarBindingRelationship::getBindState, DriverCarConstants.DRIVER_CAR_BIND));

        if (driverCarBindingRelationships.size() == 0) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getCode(), CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getValue());
        }

        LocalDateTime now = LocalDateTime.now();
        driverCarBindingRelationship = driverCarBindingRelationships.get(0);
        driverCarBindingRelationship.setUnBindingTime(now);
        driverCarBindingRelationship.setBindState(DriverCarConstants.DRIVER_CAR_UNBIND);
        driverCarBindingRelationshipMapper.updateById(driverCarBindingRelationship);
        return ResponseResult.success("解除绑定成功！");
    }
}

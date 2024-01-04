package com.lwx.serviceDriverUser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.internalcommon.dto.DriverUserWorkStatus;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.mapper.DriverUserWorkStatusMapper;
import com.lwx.serviceDriverUser.service.IDriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-16  14:27
 */
@Service
public class DriverUserWorkStatusImpl extends ServiceImpl<DriverUserWorkStatusMapper, DriverUserWorkStatus> implements IDriverUserWorkStatusService {

    @Autowired
    DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus) {
        List<DriverUserWorkStatus> driverUserWorkStatuses = driverUserWorkStatusMapper.selectList(new LambdaQueryWrapper<DriverUserWorkStatus>()
                .eq(DriverUserWorkStatus::getDriverId, driverUserWorkStatus.getDriverId()));
        if (driverUserWorkStatuses.isEmpty()) {
            return ResponseResult.fail("没有司机状态！");
        }
        DriverUserWorkStatus status = driverUserWorkStatuses.get(0);
        status.setWorkStatus(driverUserWorkStatus.getWorkStatus());
        driverUserWorkStatusMapper.updateById(status);
        return ResponseResult.success("");
    }
}

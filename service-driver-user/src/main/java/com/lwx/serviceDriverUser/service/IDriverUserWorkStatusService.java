package com.lwx.serviceDriverUser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.internalcommon.dto.DriverUserWorkStatus;
import com.lwx.internalcommon.dto.ResponseResult;

public interface IDriverUserWorkStatusService extends IService<DriverUserWorkStatus> {

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus);
}

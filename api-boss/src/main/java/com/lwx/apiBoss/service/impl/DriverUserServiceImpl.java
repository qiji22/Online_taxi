package com.lwx.apiBoss.service.impl;

import com.lwx.apiBoss.remote.ServiceDriverUserClient;
import com.lwx.apiBoss.service.IDriverUserService;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-04  10:48
 */
@Service
public class DriverUserServiceImpl implements IDriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addDriverUser(DriverUser driverUser) {
        return serviceDriverUserClient.addDriverUser(driverUser);
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.updateDriverUser(driverUser);
    }
}

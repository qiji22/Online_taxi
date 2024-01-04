package com.lwx.aPiDriver.service.Impl;

import com.lwx.aPiDriver.remote.ServiceDriverUserClient;
import com.lwx.aPiDriver.service.IUserService;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-06  15:22
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;


    public ResponseResult updateDriverUser(DriverUser driverUser){
        return serviceDriverUserClient.updateDriverUser(driverUser);
    }

    public ResponseResult addUser(DriverUser driverUser){
        return serviceDriverUserClient.addUser(driverUser);
    };

}

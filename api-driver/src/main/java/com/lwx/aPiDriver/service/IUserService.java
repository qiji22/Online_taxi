package com.lwx.aPiDriver.service;

import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;


/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-06  15:21
 */
public interface IUserService {

    /*
     * @description:修改用户信息
     * @return:
     **/
    public ResponseResult updateDriverUser(DriverUser driverUser);


    public ResponseResult addUser(DriverUser driverUser);

}

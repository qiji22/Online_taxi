package com.lwx.apiBoss.service;

import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-04  10:47
 */
public interface IDriverUserService{

    public ResponseResult addDriverUser(DriverUser driverUser);

    /*
     * @description:修改用户信息
     * @return:
     **/
    public ResponseResult updateDriverUser(DriverUser driverUser);
}

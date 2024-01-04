package com.lwx.serviceDriverUser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.ResponseResult;


public interface IDriverUserService extends IService<DriverUser> {
    public ResponseResult addDriverUser(DriverUser driverUser);

    /*
     * @description:修改用户信息
     * @return:
     **/
    public ResponseResult updateDriverUser(DriverUser driverUser);


    public ResponseResult<DriverUser> getDriverUserByPhone(String driverPhone);
}

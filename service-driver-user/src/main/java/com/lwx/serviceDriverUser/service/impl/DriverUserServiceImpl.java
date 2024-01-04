package com.lwx.serviceDriverUser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.internalcommon.constant.CommonStatusEnum;
import com.lwx.internalcommon.constant.DriverCarConstants;
import com.lwx.internalcommon.dto.DriverUser;
import com.lwx.internalcommon.dto.DriverUserWorkStatus;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.mapper.CarMapper;
import com.lwx.serviceDriverUser.mapper.DriverUserMapper;
import com.lwx.serviceDriverUser.mapper.DriverUserWorkStatusMapper;
import com.lwx.serviceDriverUser.service.IDriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DriverUserServiceImpl extends ServiceImpl<DriverUserMapper,DriverUser> implements IDriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    @Autowired
    private DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    @Autowired
    private CarMapper carMapper;


    public ResponseResult addDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtCreate(now);
        driverUser.setGmtModified(now);

        driverUserMapper.insert(driverUser);
        //初始化，司机状态表
        DriverUserWorkStatus driverUserWorkStatus = new DriverUserWorkStatus();
        driverUserWorkStatus.setDriverId(driverUser.getId());
        driverUserWorkStatus.setWorkStatus(DriverCarConstants.DRIVER_WORK_STATUS_STOP);
        driverUserWorkStatus.setGmtCreate(now);
        driverUserWorkStatusMapper.insert(driverUserWorkStatus);
        return ResponseResult.success("");
    }

    public ResponseResult updateDriverUser(DriverUser driverUser){
        LocalDateTime now = LocalDateTime.now();
        driverUser.setGmtModified(now);
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success("");
    }


    public ResponseResult<DriverUser> getDriverUserByPhone(String driverPhone){
        Map<String,Object> map = new HashMap<>();
        map.put("driver_phone", driverPhone);
        map.put("state", DriverCarConstants.DRIVER_STATE_VALID);
        List<DriverUser> driverUsers = driverUserMapper.selectByMap(map);
        if (driverUsers.isEmpty()){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST.getCode(),CommonStatusEnum.DRIVER_NOT_EXITST.getValue());
        }
        DriverUser driverUser = driverUsers.get(0);
        return ResponseResult.success(driverUser);
    }

}
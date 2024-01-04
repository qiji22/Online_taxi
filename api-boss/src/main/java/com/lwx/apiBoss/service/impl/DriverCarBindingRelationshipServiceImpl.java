package com.lwx.apiBoss.service.impl;

import com.lwx.apiBoss.remote.ServiceDriverUserClient;
import com.lwx.apiBoss.service.IDriverCarBindingRelationshipService;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-09  10:48
 */
@Service
public class DriverCarBindingRelationshipServiceImpl implements IDriverCarBindingRelationshipService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship) {
        //判断，如果参数中的车辆和司机，已经做过绑定，则不允许再次绑定
        return serviceDriverUserClient.bind(driverCarBindingRelationship);
    }

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship) {
        return serviceDriverUserClient.unbind(driverCarBindingRelationship);
    }

}

package com.lwx.serviceDriverUser.controller;

import com.lwx.internalcommon.dto.DriverUserWorkStatus;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.serviceDriverUser.service.IDriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-16  14:25
 */
@RestController
public class DriverUserWorkStatusController {

    @Autowired
    private IDriverUserWorkStatusService iDriverUserWorkStatusService;

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus){
        return iDriverUserWorkStatusService.changeWorkStatus(driverUserWorkStatus);
    }
}

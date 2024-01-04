package com.lwx.serviceDriverUser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

public interface IDriverCarBindingRelationshipService extends IService<DriverCarBindingRelationship> {

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship);

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship);

}

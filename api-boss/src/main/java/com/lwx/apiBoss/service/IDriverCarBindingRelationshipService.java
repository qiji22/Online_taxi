package com.lwx.apiBoss.service;

import com.lwx.internalcommon.dto.DriverCarBindingRelationship;
import com.lwx.internalcommon.dto.ResponseResult;

public interface IDriverCarBindingRelationshipService{

    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship);

    public ResponseResult unbind(DriverCarBindingRelationship driverCarBindingRelationship);

}

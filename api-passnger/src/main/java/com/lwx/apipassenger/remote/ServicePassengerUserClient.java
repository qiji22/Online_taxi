package com.lwx.apipassenger.remote;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.VerificationCodeDTO;
import com.lwx.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public ResponseResult loginOrReg(@RequestBody VerificationCodeDTO verificationCodeDTO);

    @RequestMapping(method = RequestMethod.GET,value = "/user/{phone}")
    public ResponseResult getUserByPhone(@PathVariable("phone") String phone);

}

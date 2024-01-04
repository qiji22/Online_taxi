package com.lwx.aPiDriver.remote;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.PointRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-map")
public interface ServiceMapClient {

    @PostMapping("/point/upload")
    public ResponseResult upload(@RequestBody PointRequest pointRequest);
}

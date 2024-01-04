package com.lwx.apipassenger.remote;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-order")
public interface ServiceOrderClient {

    @PostMapping("/order/add")
    public ResponseResult saveOrder(@RequestBody OrderRequest orderRequest);
}

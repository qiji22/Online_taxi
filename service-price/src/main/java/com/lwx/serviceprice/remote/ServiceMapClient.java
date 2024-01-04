package com.lwx.serviceprice.remote;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ForecastPriceDTO;
import com.lwx.internalcommon.response.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.GET,value = "/direction/driving")
    public ResponseResult<DirectionResponse> direction(@RequestBody ForecastPriceDTO forecastPriceDTO);

}

package com.lwx.serviceprice.controller;

import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ForecastPriceDTO;
import com.lwx.serviceprice.service.ForecastPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-04  16:38
 */
@RestController
public class ForecastPriceController {
    @Autowired
    private ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String depLongitude = forecastPriceDTO.getDepLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude);
    }

}

package com.lwx.apipassenger.service;

import com.lwx.apipassenger.remote.ServicePriceClient;
import com.lwx.internalcommon.dto.ResponseResult;
import com.lwx.internalcommon.request.ForecastPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  16:56
 */
@Service
public class ForecastPriceService {

    @Autowired
    private ServicePriceClient servicePriceClient;

    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){

        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);

        return servicePriceClient.forecast(forecastPriceDTO);
    }
}

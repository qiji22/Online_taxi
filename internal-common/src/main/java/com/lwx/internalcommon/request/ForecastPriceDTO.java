package com.lwx.internalcommon.request;

import lombok.Data;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-21  16:31
 */
@Data
public class ForecastPriceDTO {

    private String depLongitude;

    private String depLatitude;

    private  String destLongitude;

    private  String destLatitude;
}

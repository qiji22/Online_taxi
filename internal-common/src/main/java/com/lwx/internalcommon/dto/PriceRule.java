package com.lwx.internalcommon.dto;

import lombok.Data;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-06  11:23
 */
@Data
public class PriceRule {

    private String cityCode;
    private String vehicleType;
    private Double startFare;
    private Integer startMile;
    private Double unitPricePerMile;
    private Double unitPricePerMinute;
    private Integer fareVersion;
    private String fareType;

}

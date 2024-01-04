package com.lwx.internalcommon.request;

import lombok.Data;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-26  09:04
 */
@Data
public class ApiDriverPointDTO {

    private Long carId;
    private PointDTO[] points;

}

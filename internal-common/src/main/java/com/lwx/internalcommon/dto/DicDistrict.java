package com.lwx.internalcommon.dto;

import lombok.Data;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-09-08  08:44
 */
@Data
public class DicDistrict {

    private  String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;
}

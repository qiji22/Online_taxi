package com.lwx.internalcommon.request;

import lombok.Data;

import java.util.List;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-10-25  15:55
 */
@Data
public class PointRequest {
    private String tid;
    private String trid;
    private PointDTO[] points;
}

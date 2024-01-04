package com.lwx.internalcommon.response;

import lombok.Data;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  15:02
 */
@Data
public class TokenResponse {
    private String accessToken;

    private  String refreshToken;
}

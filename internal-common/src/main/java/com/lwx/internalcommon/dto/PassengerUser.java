package com.lwx.internalcommon.dto;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: MR_LWX
 * @CreateTime: 2023-08-03  16:14
 */
@Data
public class PassengerUser {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
    
    private String passengerPhone;
    
    private String passengerName;
    
    private byte passengerGender;

    private byte state;

    private String profilePhoto;

}

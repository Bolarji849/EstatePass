package com.byteBuilders.estatePass.dtos;

import lombok.Data;

@Data
public class ValidateOTPRequest {
    private String otp;
    private String name;
//    private String phoneNumber;
}

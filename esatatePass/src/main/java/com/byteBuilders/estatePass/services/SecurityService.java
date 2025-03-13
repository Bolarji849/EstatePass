package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.dtos.OtpResponse;
import com.byteBuilders.estatePass.dtos.ValidateOTPRequest;

public interface SecurityService {
    OtpResponse validateOtp(ValidateOTPRequest request);
}
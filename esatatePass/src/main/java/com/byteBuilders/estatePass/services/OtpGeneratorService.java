package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.dtos.OtpRequest;

public interface OtpGeneratorService {
    String generateOtp(OtpRequest otpRequest);
    void deleteOtp();


}

package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.Exception.OtpNotFoundException;
import com.byteBuilders.estatePass.data.model.OtpGenerator;
import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.data.repository.OTPRepo;
import com.byteBuilders.estatePass.data.repository.VisitorsPassRepo;
import com.byteBuilders.estatePass.dtos.OtpResponse;
import com.byteBuilders.estatePass.dtos.ValidateOTPRequest;
import com.byteBuilders.estatePass.utills.OTPMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class SecurityServicelmp implements SecurityService{
    @Autowired
    OTPRepo otpRepo;
    @Autowired
    VisitorsPassRepo visitorsPassRepo;

    @Override
    public OtpResponse validateOtp(ValidateOTPRequest request) {
        OtpGenerator otpinfo = otpRepo.findGenerateOtpByOtp(request.getOtp()).orElseThrow(() -> new OtpNotFoundException("Expired OTP or Invalid OTP"));

           VisitorPass visitorPass = new VisitorPass();
           visitorPass.setTimestamp(LocalDateTime.now());
           visitorPass.setVisitorName(request.getName());
           visitorPass.setOut(Boolean.FALSE);
           visitorsPassRepo.save(visitorPass);

        return OTPMapper.mapToOtpResponse(otpinfo,visitorPass);
    }

}

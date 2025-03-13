package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.data.model.OtpGenerator;
import com.byteBuilders.estatePass.data.repository.OTPRepo;
import com.byteBuilders.estatePass.dtos.OtpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OtpGeneratorImp implements OtpGeneratorService {
    private static final String OTP_PREFIX = "APT";
    private static final int OTP_LENGTH = 6;

    @Autowired
    private OTPRepo otpRepo;



    @Override
    public String generateOtp(OtpRequest otpRequest) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_PREFIX);

        for (int number = 0; number < OTP_LENGTH; number++) {
            otp.append(secureRandom.nextInt(10));
        }
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(1);

        OtpGenerator otpInfo = new OtpGenerator();
        otpInfo.setOtp(otp.toString());
        otpInfo.setExpirationTime(expirationTime);
        otpInfo.setEmail(otpRequest.getEmail());
        otpInfo.setName(otpRequest.getName());
        otpInfo.setPhoneNumber(otpRequest.getPhoneNumber());
        otpRepo.save(otpInfo);


        return otp.toString();
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void deleteOtp() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<OtpGenerator> expiredOtp = otpRepo.findGenerateOtpByExpirationTimeBefore(currentTime);

        if(!expiredOtp.isEmpty()){
            otpRepo.deleteAll(expiredOtp);
        }

    }



    }



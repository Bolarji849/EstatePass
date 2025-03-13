package com.byteBuilders.estatePass.controllers;

import com.byteBuilders.estatePass.dtos.OtpRequest;
import com.byteBuilders.estatePass.services.OtpGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpGeneratorController {
    @Autowired
    OtpGeneratorService otpGeneratorService;


    @PostMapping("/generate")
    String generateOtp(@RequestBody OtpRequest otpRequest){
        return  otpGeneratorService.generateOtp(otpRequest);

    }





}

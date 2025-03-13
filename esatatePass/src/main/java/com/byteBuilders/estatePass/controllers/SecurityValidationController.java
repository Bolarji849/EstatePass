package com.byteBuilders.estatePass.controllers;


import com.byteBuilders.estatePass.dtos.OtpResponse;
import com.byteBuilders.estatePass.dtos.ValidateOTPRequest;
import com.byteBuilders.estatePass.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityValidationController {
    @Autowired
    SecurityService securityService;

    @PostMapping("/validate")
    OtpResponse validateOtp(@RequestBody ValidateOTPRequest validateOTPRequest){
        return securityService.validateOtp(validateOTPRequest);
    }

}

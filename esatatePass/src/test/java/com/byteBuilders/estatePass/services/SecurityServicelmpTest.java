package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.data.repository.OTPRepo;
import com.byteBuilders.estatePass.data.repository.TenantRepository;
import com.byteBuilders.estatePass.dtos.OtpRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import com.byteBuilders.estatePass.dtos.ValidateOTPRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SecurityServicelmpTest {

    @Autowired
    SecurityService securityService;
    @Autowired
    OTPRepo otpRepo;
    @Autowired
    TenantRepository tenantRepo;
    @Autowired
    OtpGeneratorService otpGeneratorService;
    @Autowired
    TenantService tenantService;
    @BeforeEach
    void setUp() {
        tenantRepo.deleteAll();
        otpRepo.deleteAll();
    }


    @Test
    public void testOtpValidation() {
        TenantRequest request = new TenantRequest();
        request.setFirstName("John");
        request.setLastName("Waide");
        request.setPassword("63t7436");
        request.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request);
        assertEquals(1, tenantService.numberOfTenants());

        OtpRequest otpRequest = new OtpRequest();
        otpRequest.setName(String.join("Micheal", "helo"));
        otpRequest.setEmail("waide@gmail.com");


        String otp = otpGeneratorService.generateOtp(otpRequest);
        assertNotNull(otp);
         ValidateOTPRequest  validateOTPRequest = new ValidateOTPRequest();
         String name = String.join("", "Micheal", "helo");
        validateOTPRequest.setOtp(otp);
        validateOTPRequest.setName(name);

        assertEquals(1, otpRepo.count());

        assertEquals(otp, securityService.validateOtp(validateOTPRequest).getOtpGenerator().getOtp());
    }



}
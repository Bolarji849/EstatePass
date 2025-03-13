package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.data.model.OtpGenerator;
import com.byteBuilders.estatePass.data.repository.OTPRepo;
import com.byteBuilders.estatePass.data.repository.TenantRepository;
import com.byteBuilders.estatePass.dtos.OtpRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OtpGeneratorImpTest {
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
        otpRepo.deleteAll();
        tenantRepo.deleteAll();
    }





    @Test
    public void testThatYouCanGenerateOtp() {
        TenantRequest request = new TenantRequest();
        request.setFirstName("John");
        request.setLastName("Waide");
        request.setPassword("63t7436");
        request.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request);
        assertEquals(1, tenantService.numberOfTenants());

        OtpRequest otpRequest = new OtpRequest();
        otpRequest.setName(String.join(" ", "waide"));
        otpRequest.setEmail("waide@gmail.com");


        String otp = otpGeneratorService.generateOtp(otpRequest);
        assertNotNull(otp);

        List<OtpGenerator> otpList = otpRepo.findAll();
        assertEquals(1, otpList.size());
        assertEquals(otp, otpList.get(0).getOtp());
    }

    @Test
    public void testThatOtpIsDeletedAfterItExpires() throws InterruptedException {
        TenantRequest request = new TenantRequest();
        request.setFirstName("John");
        request.setLastName("Waide");
        request.setPassword("63t7436");
        request.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request);
        assertEquals(1, tenantService.numberOfTenants());

        OtpRequest otpRequest = new OtpRequest();
        otpRequest.setName(String.join("john", "Waide"));
        otpRequest.setEmail("wae@gmail.com");


        String otp = otpGeneratorService.generateOtp(otpRequest);
        assertNotNull(otp);


        assertEquals(1, otpRepo.count());


        Thread.sleep(61000);

        otpGeneratorService.deleteOtp();


        assertEquals(0, otpRepo.count());

    }





}
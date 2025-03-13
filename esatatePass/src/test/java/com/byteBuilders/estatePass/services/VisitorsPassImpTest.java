package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.data.repository.VisitorsPassRepo;
import com.byteBuilders.estatePass.dtos.OtpRequest;
import com.byteBuilders.estatePass.dtos.ValidateOTPRequest;
import com.byteBuilders.estatePass.dtos.VisitorsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitorsPassImpTest {

    @Autowired
    VisitorsPassService visitorsPassService;
    @Autowired
    VisitorsPassRepo visitorsPassRepo;
    @Autowired
    OtpGeneratorService otpGeneratorService;
    @Autowired
    SecurityService securityService;
    @Autowired
    VisitorsPassRepo repo;
    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }


    @Test
    public void testThatICanUpdatedAGeneratedVisitorsPass() {

        OtpRequest otpRequest = new OtpRequest();
        otpRequest.setName(String.join("john", "Waide"));
        otpRequest.setEmail("wae@gmail.com");

        String otp = otpGeneratorService.generateOtp(otpRequest);
        assertNotNull(otp);
        ValidateOTPRequest validateOTPRequest = new ValidateOTPRequest();
        validateOTPRequest.setOtp(otp);
        securityService.validateOtp(validateOTPRequest);

        List<VisitorPass> foundVisitorPass = repo.findAll();
        VisitorPass generatedPass = visitorsPassService.UpdatePass(foundVisitorPass.get(0).getId());
        assertNotNull(generatedPass);

        assertEquals(1,repo.count());

    }


}



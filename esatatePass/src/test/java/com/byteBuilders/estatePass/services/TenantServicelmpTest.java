package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.Exception.EmailExistExceptions;
import com.byteBuilders.estatePass.data.repository.TenantRepository;
import com.byteBuilders.estatePass.dtos.LoginRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TenantServicelmpTest {
    @Autowired
    TenantService tenantService;
    @Autowired
    TenantRepository tenantRepository;
    @BeforeEach
    void setUp() {
        tenantRepository.deleteAll();
    }
    @Test
    public void testThaTenantCanCreateAccount() {

        TenantRequest request = new TenantRequest();
        request.setFirstName("John");
        request.setLastName("Waide");
        request.setPassword("63t7436");
        request.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request);
        assertThat(response.getMessage()).isEqualTo("Account created successfully");
    }

    @Test
    public void testThaTenantCannotCreateAccountTwice() {

        TenantRequest request1 = new TenantRequest();
        request1.setFirstName("John");
        request1.setLastName("Waide");
        request1.setPassword("63t7436");
        request1.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request1);
        assertThrows(EmailExistExceptions.class,()->tenantService.registerTenant(request1));
    }

    @Test
    public void testThatTenantCanLogin(){
        TenantRequest request = new TenantRequest();
        request.setFirstName("John");
        request.setLastName("Waide");
        request.setPassword("63t7436");
        request.setEmail("wae@gmail.com");

        TenantResponse response = tenantService.registerTenant(request);
        assertThat(response.getMessage()).isEqualTo("Account created successfully");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("wae@gmail.com");
        loginRequest.setPassword("63t7436");

        boolean login = tenantService.login(loginRequest);
        assertTrue(login);
    }

}






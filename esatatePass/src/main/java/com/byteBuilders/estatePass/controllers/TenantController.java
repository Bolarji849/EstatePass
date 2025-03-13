package com.byteBuilders.estatePass.controllers;

import com.byteBuilders.estatePass.dtos.LoginRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import com.byteBuilders.estatePass.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {

    @Autowired
    TenantService tenantService;


    @PostMapping("/register")
    TenantResponse registerTenant(@RequestBody TenantRequest tenantRequest){
        return tenantService.registerTenant(tenantRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        boolean loginDetails = tenantService.login(loginRequest);
        if(loginDetails){
            return  new ResponseEntity<>("login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("login failed", HttpStatus.UNAUTHORIZED);
    }



}


package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.Exception.UserAlreadyExistException;
import com.byteBuilders.estatePass.Exception.UserNotFoundException;
import com.byteBuilders.estatePass.data.model.Tenant;
import com.byteBuilders.estatePass.data.repository.TenantRepository;
import com.byteBuilders.estatePass.dtos.LoginRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import com.byteBuilders.estatePass.utills.TenantMapper;
//import com.byteBuilders.estatePass.utills.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServicelmp implements TenantService{
    @Autowired
    TenantMapper mapper;
    @Autowired
    TenantRepository repo;

//    @Autowired
//    Validation validation;


    @Override
    public TenantResponse registerTenant(TenantRequest tenantRequest) {
        if(repo.existsByEmail(tenantRequest.getEmail())){
            throw new UserAlreadyExistException(tenantRequest.getEmail());
        }
//        validation.validateTenantEmail(tenantRequest.getEmail());
        Tenant tenant = mapper.mapTORequest(tenantRequest);
         repo.save(tenant);

        TenantResponse tenantResponse = mapper.mapTOResponse("Account successfully created");


        return tenantResponse;
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
         mapper.mapToLoginRequest(loginRequest);
        Tenant foundTenant = findTenantByEmail(loginRequest.getEmail());
        if(foundTenant.isLoggedIn()) {
            throw new UserAlreadyExistException("Already logged in");
        }
        if(foundTenant.getPassword().equals(loginRequest.getPassword())) {
            foundTenant.setLoggedIn(true);

        }
        repo.save(foundTenant);
        
        return foundTenant.isLoggedIn();


    }

    private Tenant findTenantByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    @Override
    public int numberOfTenants() {
        return repo.findAll().size();
    }
}

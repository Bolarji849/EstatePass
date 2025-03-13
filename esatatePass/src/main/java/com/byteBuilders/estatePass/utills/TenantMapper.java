package com.byteBuilders.estatePass.utills;

import com.byteBuilders.estatePass.data.model.Tenant;
import com.byteBuilders.estatePass.dtos.LoginRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;
import org.springframework.stereotype.Component;


@Component
public class TenantMapper {

    public Tenant mapTORequest(TenantRequest tenantRequest) {
        Tenant tenant = new Tenant();
        tenant.setFirstName(tenantRequest.getFirstName());
        tenant.setLastName(tenantRequest.getLastName());
        tenant.setEmail(tenantRequest.getEmail());
        tenant.setPassword(tenantRequest.getPassword());
    return tenant;
    }

    public  TenantResponse mapTOResponse(String tenantResponse) {
        TenantResponse tenantResponse1 = new TenantResponse();
        tenantResponse1.setMessage("Account created successfully");

        return tenantResponse1;
    }

    public void mapToLoginRequest(LoginRequest loginRequest) {
        Tenant tenant = new Tenant();
        tenant.setEmail(loginRequest.getEmail());
        tenant.setPassword(loginRequest.getPassword());
    }


}


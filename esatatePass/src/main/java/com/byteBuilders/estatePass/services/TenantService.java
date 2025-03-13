package com.byteBuilders.estatePass.services;

import com.byteBuilders.estatePass.dtos.LoginRequest;
import com.byteBuilders.estatePass.dtos.TenantRequest;
import com.byteBuilders.estatePass.dtos.TenantResponse;

public interface TenantService {
    TenantResponse registerTenant(TenantRequest tenantRequest);
     boolean login(LoginRequest loginRequest);

    int numberOfTenants();
}

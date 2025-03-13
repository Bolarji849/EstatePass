//package com.byteBuilders.estatePass.utills;
//
//import com.byteBuilders.estatePass.Exception.EmailExistExceptions;
//import com.byteBuilders.estatePass.data.model.Tenant;
//import com.byteBuilders.estatePass.data.repository.TenantRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Validation {
//    @Autowired
//    private TenantRepository tenantRepository;
//
//
//    public void validateTenantEmail(String email) {
//        List<Tenant>tenants = tenantRepository.findAll();
//        if(tenants.isEmpty()) throw new EmailExistExceptions("Tenant Repo is empty");
//        else {
//            for (Tenant tenant : tenants)
//                if (tenant.getEmail().equals(email)) throw new EmailExistExceptions("Email already exists");
//        }
//    }
//}

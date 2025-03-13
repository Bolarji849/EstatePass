package com.byteBuilders.estatePass.data.repository;

import com.byteBuilders.estatePass.data.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TenantRepository extends MongoRepository<Tenant, String> {

    Optional<Tenant>  findByEmail(String email);

    boolean existsByEmail(String email);
}

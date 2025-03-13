package com.byteBuilders.estatePass.data.repository;

import com.byteBuilders.estatePass.data.model.VisitorPass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitorsPassRepo extends MongoRepository<VisitorPass, String> {
}

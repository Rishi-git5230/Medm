package com.systech.hawkeye.repository;

import com.systech.hawkeye.model.MedmModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedmRepository extends MongoRepository<MedmModel, String> {
}

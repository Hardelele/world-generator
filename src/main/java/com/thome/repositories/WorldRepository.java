package com.thome.repositories;

import com.thome.entities.WorldEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldRepository extends MongoRepository<WorldEntity, String> {
}

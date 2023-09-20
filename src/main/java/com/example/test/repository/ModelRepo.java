package com.example.test.repository;

import com.example.test.entity.ModelEntity;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepo extends CrudRepository<ModelEntity, Long> {
    ModelEntity findByModelName(String modelName);
}

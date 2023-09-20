package com.example.test.repository;

import com.example.test.entity.BrandEntity;
import com.example.test.entity.ModelEntity;
import com.example.test.entity.PositionEntity;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepo extends CrudRepository<PositionEntity, Long> {
    PositionEntity findByBrand(String brand);
    PositionEntity findByModel(String model);
}

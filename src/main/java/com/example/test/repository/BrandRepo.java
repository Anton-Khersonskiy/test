package com.example.test.repository;

import com.example.test.entity.BrandEntity;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepo extends CrudRepository<BrandEntity, Long> {
    BrandEntity findByBrandName(String brandName);
}

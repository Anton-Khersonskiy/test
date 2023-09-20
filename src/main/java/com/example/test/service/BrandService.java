package com.example.test.service;

import com.example.test.entity.BrandEntity;
import com.example.test.exception.BrandAlreadyExistException;
import com.example.test.exception.BrandNotFoundException;
import com.example.test.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;
    public BrandEntity create(BrandEntity brand) throws BrandAlreadyExistException {
        if (brandRepo.findByBrandName(brand.getBrandName()) != null) {
            throw new BrandAlreadyExistException("Такая марка автомобиля уже существует");
        }
        return brandRepo.save(brand);
    }

    public BrandEntity findByBrandName(String name) throws BrandNotFoundException {
        BrandEntity brand = brandRepo.findByBrandName(name);
        if (brand == null) {
            throw new BrandNotFoundException("Марка автомобиля не найдена");
        }
        return brand;
    }
    public BrandEntity update(String brandName) throws BrandNotFoundException {
        BrandEntity brand = brandRepo.findByBrandName(brandName);
        if (brand == null) {
            throw new BrandNotFoundException("Марка автомобиля не найдена");
        }
        brand.setBrandName("Неизвестная марка");
        return brandRepo.save(brand);
    }
    public Long delete(Long id) {
        brandRepo.deleteById(id);
        return id;
    }
}

package com.example.test.service;

import com.example.test.entity.PositionEntity;
import com.example.test.exception.BrandAlreadyExistException;
import com.example.test.exception.BrandNotFoundException;
import com.example.test.exception.PositionNotFoundException;
import com.example.test.repository.BrandRepo;
import com.example.test.repository.ModelRepo;
import com.example.test.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepo positionRepo;

    public PositionEntity create(PositionEntity position) {
        return positionRepo.save(position);
    }
    public PositionEntity getByBrand(String brand) throws PositionNotFoundException {
        PositionEntity position = positionRepo.findByBrand(brand);
        if (position == null) {
            throw new PositionNotFoundException("Объявление не найдено");
        }
        return position;
    }

    public PositionEntity getByModel(String model) throws PositionNotFoundException {
        PositionEntity position = positionRepo.findByModel(model);
        if (position == null) {
            throw new PositionNotFoundException("Объявление не найдено");
        }
        return position;
    }
    public PositionEntity update(Long id) throws PositionNotFoundException {
        PositionEntity position = positionRepo.findById(id).get();
        if (position == null) {
            throw new PositionNotFoundException("Объявление не найдено");
        }
        Long discount = (long) (position.getPrice()*0.8);
        position.setPrice(discount);
        return position;
    }
    public Long delete(Long id) {
        positionRepo.deleteById(id);
        return id;
    }
}

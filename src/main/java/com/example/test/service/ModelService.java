package com.example.test.service;

import com.example.test.entity.ModelEntity;
import com.example.test.exception.ModelAlreadyExistException;
import com.example.test.exception.ModelNotFoundException;
import com.example.test.repository.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    @Autowired
    private ModelRepo modelRepo;
    public ModelEntity create(ModelEntity model) throws ModelAlreadyExistException {
        if (modelRepo.findByModelName(model.getModelName()) != null) {
            throw new ModelAlreadyExistException("Такая модель автомобиля уже существует");
        }
        return modelRepo.save(model);
    }
    public ModelEntity findByModelName(String name) throws ModelNotFoundException {
        ModelEntity model = modelRepo.findByModelName(name);
        if (model == null) {
            throw new ModelNotFoundException("Модель автомобиля не найдена");
        }
        return model;
    }
    public ModelEntity update(String modelName) throws ModelNotFoundException {
        ModelEntity model = modelRepo.findByModelName(modelName);
        if (model == null) {
            throw new ModelNotFoundException("Модель автомобиля не найдена");
        }
        model.setModelName("Неизвестная модель");
        return model;
    }
    public Long delete(Long id) {
        modelRepo.deleteById(id);
        return id;
    }
}

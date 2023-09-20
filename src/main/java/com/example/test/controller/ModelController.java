package com.example.test.controller;


import com.example.test.entity.ModelEntity;
import com.example.test.exception.ModelAlreadyExistException;
import com.example.test.exception.ModelNotFoundException;
import com.example.test.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping
    public ResponseEntity addModel(@RequestBody ModelEntity model) {
        try {
            modelService.create(model);
            return ResponseEntity.ok("Модель автомобиля успешно сохранена");
        } catch (ModelAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getOneModel(@RequestParam String name) {
        try {
            return ResponseEntity.ok(modelService.findByModelName(name));
        } catch (ModelNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity updateModel(@RequestParam String modelName) {
        try {
            return ResponseEntity.ok(modelService.update(modelName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteModel(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(modelService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

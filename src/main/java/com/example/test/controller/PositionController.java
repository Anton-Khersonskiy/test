package com.example.test.controller;

import com.example.test.entity.ModelEntity;
import com.example.test.entity.PositionEntity;
import com.example.test.exception.ModelAlreadyExistException;
import com.example.test.exception.ModelNotFoundException;
import com.example.test.exception.PositionNotFoundException;
import com.example.test.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping
    public ResponseEntity addPosition(@RequestBody PositionEntity position) {
        try {
            positionService.create(position);
            return ResponseEntity.ok("Объявление успешно сохранено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/brand")
    public ResponseEntity getPositionByBrand(@RequestParam String brand) {
        try {
            return ResponseEntity.ok(positionService.getByBrand(brand));
        } catch (PositionNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/model")
    public ResponseEntity getPositionByModel(@RequestParam String model) {
        try {
            return ResponseEntity.ok(positionService.getByModel(model));
        } catch (PositionNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity updatePosition(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(positionService.update(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePosition(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(positionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

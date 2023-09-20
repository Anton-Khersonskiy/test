package com.example.test.controller;

import com.example.test.entity.BrandEntity;
import com.example.test.exception.BrandAlreadyExistException;
import com.example.test.exception.BrandNotFoundException;
import com.example.test.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity addBrand(@RequestBody BrandEntity brand) {
        try {
            brandService.create(brand);
            return ResponseEntity.ok("Марка автомобиля успешно сохранена");
        } catch (BrandAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getOneBrandByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(brandService.findByBrandName(name));
        } catch (BrandNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity updateBrand(@RequestParam String name) {
        try {
            return ResponseEntity.ok(brandService.update(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(brandService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
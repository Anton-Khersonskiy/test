package com.example.test.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year_release")
    private Long yearRelease;
    @Column(name = "mileage")
    private Long mileage;
    @Column(name = "price")
    private Long price;

    public PositionEntity() {
    }
    public Long getPositionId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(Long year_release) {
        this.yearRelease = year_release;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

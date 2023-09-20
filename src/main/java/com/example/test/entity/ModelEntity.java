package com.example.test.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "model")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "year_start")
    private Long year_start;
    @Column(name = "year_end")
    private Long year_end;

    public ModelEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getYear_start() {
        return year_start;
    }

    public void setYear_start(Long year_start) {
        this.year_start = year_start;
    }

    public Long getYear_end() {
        return year_end;
    }

    public void setYear_end(Long year_end) {
        this.year_end = year_end;
    }
}

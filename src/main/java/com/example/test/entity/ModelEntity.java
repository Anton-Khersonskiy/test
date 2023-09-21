package com.example.test.entity;

import jakarta.persistence.*;

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
    private Long yearStart;
    @Column(name = "year_end")
    private Long yearEnd;

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

    public Long getYearStart() {
        return yearStart;
    }

    public void setYearStart(Long year_start) {
        this.yearStart = year_start;
    }

    public Long getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Long year_end) {
        this.yearEnd = year_end;
    }
}

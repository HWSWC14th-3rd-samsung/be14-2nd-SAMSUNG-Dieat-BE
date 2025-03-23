package com.samsung.dieat.open_data_food.command.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_open_data_food")
public class OpenDataFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odf_code")
    private Integer code;

    private String name;
    private Float calories;
    private Float carbs;
    private Float sugar;
    private Float protein;
    private Float fat;

    @Column(name = "odf_update_dt")
    private LocalDateTime updateDate;

    protected OpenDataFood() {}

    public OpenDataFood(String name, Float calories, Float carbs, Float sugar,
                        Float protein, Float fat, LocalDateTime updateDate) {
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.sugar = sugar;
        this.protein = protein;
        this.fat = fat;
        this.updateDate = updateDate;
    }

    public void update(String name, Float calories, Float carbs, Float sugar,
                       Float protein, Float fat, LocalDateTime updateDate) {
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.sugar = sugar;
        this.protein = protein;
        this.fat = fat;
        this.updateDate = updateDate;
    }

    public Integer getCode() {
        return code;
    }
}
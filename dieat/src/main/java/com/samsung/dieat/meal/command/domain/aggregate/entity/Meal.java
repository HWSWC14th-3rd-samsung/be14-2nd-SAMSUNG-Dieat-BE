package com.samsung.dieat.meal.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_code")
    private int mealCode;

    @Column(name = "meal_dt")
    private LocalDate mealDt;

    @Column(name = "meal_title")
    private String mealTitle;

    @Column(name = "meal_desc")
    private String mealDesc;

    @Column(name = "meal_calories")
    private float mealCalories;

    @Column(name = "meal_carbs")
    private float mealCarbs;

    @Column(name = "meal_sugar")
    private float mealSugar;

    @Column(name = "meal_protein")
    private float mealProtein;

    @Column(name = "meal_fat")
    private float mealFat;

    @Column(name = "user_code")
    private int userCode;

}
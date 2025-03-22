package com.samsung.dieat.meal.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_meal")
public class Meal {

    @Id
    @Column(name = "meal_code")
    private int mealCode;

    @Column(name = "meal_dt")
    private LocalDate mealDt;

    @Column(name = "meal_title")
    private String mealTitle;

    @Column(name = "meal_desc")
    private String mealDesc;

    @Column(name = "meal_calories")
    private int mealCalories;

    @Column(name = "meal_carbs")
    private int mealCarbs;

    @Column(name = "meal_sugar")
    private int mealSugar;

    @Column(name = "meal_protein")
    private int mealProtein;

    @Column(name = "meal_fat")
    private int mealFat;

    @Column(name = "user_code")
    private int userCode;

}
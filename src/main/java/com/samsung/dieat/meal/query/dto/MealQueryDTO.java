package com.samsung.dieat.meal.query.dto;

import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MealQueryDTO {
    private int mealCode;
    private String mealDt;
    private String mealTitle;
    private String mealDesc;
    private float mealCalories;
    private float mealCarbs;
    private float mealSugar;
    private float mealProtein;
    private float mealFat;
    private int userCode;

    private List<MealFoodQueryDTO> mealFoods;
}


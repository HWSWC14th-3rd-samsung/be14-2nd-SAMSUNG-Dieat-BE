package com.samsung.dieat.meal.command.application.dto;

import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import lombok.*;

import java.util.List;

<<<<<<< HEAD
=======
@Setter
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MealCommandDTO {
    private int userCode;
    private String mealDt;
    private String mealTitle;
    private String mealDesc;
    private float mealCalories;
    private float mealCarbs;
    private float mealSugar;
    private float mealProtein;
    private float mealFat;
    private List<MealFoodDTO> mealFoods;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class MealFoodDTO {
        private int mealFoodCode;
        private MealFoodType mealFoodType;
        private int mealFoodCnt;
    }
<<<<<<< HEAD
=======


>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}
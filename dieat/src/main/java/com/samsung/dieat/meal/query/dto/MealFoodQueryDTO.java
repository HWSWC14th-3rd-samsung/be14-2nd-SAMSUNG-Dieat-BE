package com.samsung.dieat.meal.query.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MealFoodQueryDTO {
    private int mealFoodCode;
    private String mealFoodType;
    private int mealCode;
    private int mealFoodCnt;

}

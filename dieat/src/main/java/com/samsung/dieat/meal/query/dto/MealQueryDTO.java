package com.samsung.dieat.meal.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    /* 제약조건이 not null이면 기본자료형, nullable이면 참조자료형 */
}


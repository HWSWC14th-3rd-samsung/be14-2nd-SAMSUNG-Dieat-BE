package com.samsung.dieat.meal.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MealDefaultSelectCondition {
    private int userCode;
    private String mealDt;
}
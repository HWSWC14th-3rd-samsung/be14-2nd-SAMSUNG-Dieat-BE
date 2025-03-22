package com.samsung.dieat.meal.query.dto;



import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MealDefaultSelectCondition {
    private int userCode;
    private String mealDt;
}
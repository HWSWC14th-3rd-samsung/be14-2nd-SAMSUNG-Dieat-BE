package com.samsung.dieat.meal.command.domain.aggregate.entity;

import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MealFoodCode implements Serializable {
    private int mealFoodCode;
    private MealFoodType mealFoodType;
}
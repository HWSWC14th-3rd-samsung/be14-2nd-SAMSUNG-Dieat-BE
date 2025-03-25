package com.samsung.dieat.meal.command.domain.aggregate.entity;

import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MealFoodCode.class)
@Table(name = "tbl_meal_food")
public class MealFood {

    @Id
    @Column(name = "meal_food_code")
    private int mealFoodCode;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "meal_food_type")
    private MealFoodType mealFoodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_code")
    private Meal meal;

    @Column(name = "meal_food_cnt")
    private int mealFoodCnt;

    public void updateCnt(int newCnt) {
        this.mealFoodCnt = newCnt;
    }
}
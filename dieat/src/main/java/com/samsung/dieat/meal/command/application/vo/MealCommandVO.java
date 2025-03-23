package com.samsung.dieat.meal.command.application.vo;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import lombok.Getter;

import java.util.List;

@Getter
public class MealCommandVO {
    private final int userCode;
    private final String mealDt;
    private final String mealTitle;
    private final String mealDesc;
    private final float mealCalories;
    private final float mealCarbs;
    private final float mealSugar;
    private final float mealProtein;
    private final float mealFat;
    private final List<MealFoodVO> mealFoods;

    public MealCommandVO(MealCommandDTO dto) {
        this.userCode = dto.getUserCode();
        this.mealDt = dto.getMealDt();
        this.mealTitle = dto.getMealTitle();
        this.mealDesc = dto.getMealDesc();
        this.mealCalories = dto.getMealCalories();
        this.mealCarbs = dto.getMealCarbs();
        this.mealSugar = dto.getMealSugar();
        this.mealProtein = dto.getMealProtein();
        this.mealFat = dto.getMealFat();
        this.mealFoods = dto.getMealFoods().stream()
                                            .map(f -> new MealFoodVO(f.getMealFoodCode(),
                                                f.getMealFoodType(),
                                                f.getMealFoodCnt()))
                                            .toList();
    }

    @Getter
    public static class MealFoodVO {
        private final int mealFoodCode;
        private final MealFoodType mealFoodType;
        private final int mealFoodCnt;

        public MealFoodVO(int mealFoodCode, MealFoodType mealFoodType, int mealFoodCnt) {
            this.mealFoodCode = mealFoodCode;
            this.mealFoodType = mealFoodType;
            this.mealFoodCnt = mealFoodCnt;
        }
    }
}
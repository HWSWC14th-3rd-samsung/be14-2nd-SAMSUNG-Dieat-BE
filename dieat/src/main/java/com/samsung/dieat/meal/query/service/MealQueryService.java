package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;


import java.util.List;


public interface MealQueryService {

    // 식사 전체 조회
    List<MealQueryDTO> getMealsByUserCode(int authenticatedUserCode);

    // 식사 목록 조회
    List<String> getMealDatesByUserCode(int userCode);

    // 식사 검색
    List<MealQueryDTO> searchMeals(MealDefaultSelectCondition condition);

    // 단일 식사 조회
    MealQueryDTO getMealByMealCodeAndUserCode(int mealCode, int userCode);
}


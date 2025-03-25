package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import org.springframework.transaction.annotation.Transactional;

public interface MealCommandService {

    // 식사 등록
    @Transactional
    void registerMeal(int authenticatedUserCode, MealCommandDTO dto);

    // 식사 수정
    @Transactional
    void updateMeal(int authenticatedUserCode, int mealCode, MealCommandDTO dto);

    // 식사 삭제
    @Transactional
    void deleteMeal(int authenticatedUserCode, int mealCode);
}
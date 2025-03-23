package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.application.vo.MealCommandVO;

public interface MealCommandRepository {
    void saveMealWithFoods(MealCommandVO vo);
}
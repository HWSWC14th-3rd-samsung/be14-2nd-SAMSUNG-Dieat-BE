package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import com.samsung.dieat.meal.query.dao.MealQueryMapper;
import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealQueryServiceImpl implements MealQueryService {

    private final MealQueryMapper mealQueryMapper;
    private final MealFoodJpaRepository mealFoodJpaRepository;

    @Override
    public List<MealQueryDTO> findAllMeals() {
        return mealQueryMapper.selectAllMeals();
    }

    @Override
    public List<MealQueryDTO> findMealsByUserCode(int userCode) {
        List<MealQueryDTO> meals = mealQueryMapper.selectMealsByUserCode(userCode);

        for (MealQueryDTO meal : meals) {
            List<MealFood> mealFoods = mealFoodJpaRepository.findByMealCodeWithMeal(meal.getMealCode());
            meal.setMealFoods(mealFoods);
        }

        return meals;
    }

    @Override
    public MealQueryDTO findMealsDefault(MealDefaultSelectCondition condition) {
        MealQueryDTO meal = mealQueryMapper.selectMealsDefault(condition);

        if (meal != null) {
            List<MealFood> mealFoods = mealFoodJpaRepository.findByMealCodeWithMeal(meal.getMealCode());
            meal.setMealFoods(mealFoods);
        }

        return meal;
    }
}
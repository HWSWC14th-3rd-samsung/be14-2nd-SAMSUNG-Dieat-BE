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
        return mealQueryMapper.selectMealsByUserCode(userCode);
    }

    @Override
    public List<MealQueryDTO> findMealsDefault(MealDefaultSelectCondition condition) {
        return mealQueryMapper.selectMealsDefault(condition);
    }

    @Override
    public List<String> findMealDateListByUserCode(int userCode) {
        return mealQueryMapper.selectMealDatesByUserCode(userCode);
    }

    @Override
    public List<String> findMealByMealCode(int mealCode) {
        return mealQueryMapper.selectMealByMealCode(mealCode);
    }
}
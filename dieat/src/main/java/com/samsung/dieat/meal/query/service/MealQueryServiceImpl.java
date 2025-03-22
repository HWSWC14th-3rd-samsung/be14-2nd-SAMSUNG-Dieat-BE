package com.samsung.dieat.meal.query.service;

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

    @Override
    public List<MealQueryDTO> findAllMeals() {
        System.out.println(mealQueryMapper.selectAllMeals());
        return mealQueryMapper.selectAllMeals();
    }

    @Override
    public List<MealQueryDTO> findMealsByUserCode(int userCode) {
        return mealQueryMapper.selectMealByUserCode(userCode);
    }

    @Override
    public MealQueryDTO findMealsDefault(MealDefaultSelectCondition condition) {
        return mealQueryMapper.selectMealsDefault(condition);
    }
}

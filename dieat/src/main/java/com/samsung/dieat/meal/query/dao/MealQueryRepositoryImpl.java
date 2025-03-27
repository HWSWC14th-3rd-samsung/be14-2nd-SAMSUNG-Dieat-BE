package com.samsung.dieat.meal.query.dao;

import com.samsung.dieat.meal.query.dto.MealFoodQueryDTO;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MealQueryRepositoryImpl implements MealQueryRepository {
    private final MealQueryMapper mealQueryMapper;


    @Override
    public List<MealQueryDTO> findMealsByUserCode(int userCode) {
        return mealQueryMapper.selectMealsByUserCode(userCode);
    }

    @Override
    public List<String> findDistinctMealDatesByUserCode(int userCode) {
        return mealQueryMapper.selectDistinctMealDatesByUserCode(userCode);
    }

    @Override
    public MealQueryDTO findMealByMealCodeAndUserCode(int mealCode, int userCode) {
        return mealQueryMapper.selectMealByMealCodeAndUserCode(mealCode, userCode);
    }

}
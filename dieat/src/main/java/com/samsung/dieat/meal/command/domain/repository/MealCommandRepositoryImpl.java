package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class MealCommandRepositoryImpl implements MealCommandRepository {

    private final MealJpaRepository mealJpaRepository;
    private final MealFoodJpaRepository mealFoodJpaRepository;

    @Override
    @Transactional
    public void saveMealWithFoods(MealCommandVO vo) {
        Meal meal = Meal.builder()
                .mealDt(vo.getMealDt())
                .mealTitle(vo.getMealTitle())
                .mealDesc(vo.getMealDesc())
                .mealCalories(vo.getMealCalories())
                .mealCarbs(vo.getMealCarbs())
                .mealSugar(vo.getMealSugar())
                .mealProtein(vo.getMealProtein())
                .mealFat(vo.getMealFat())
                .userCode(vo.getUserCode())
                .build();

        Meal savedMeal = mealJpaRepository.save(meal);

        vo.getMealFoods().forEach(f -> {
            MealFood mealFood = MealFood.builder()
                    .meal(savedMeal)
                    .mealFoodCode(f.getMealFoodCode())
                    .mealFoodType(f.getMealFoodType())
                    .mealFoodCnt(f.getMealFoodCnt())
                    .build();
            mealFoodJpaRepository.save(mealFood);
        });
    }
}
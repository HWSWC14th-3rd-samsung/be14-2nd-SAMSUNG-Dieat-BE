package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MealCommandService {

    private final MealJpaRepository mealJpaRepository;
    private final MealFoodJpaRepository mealFoodJpaRepository;

    @Transactional
    public void registerMeal(MealCommandDTO dto) {
        MealCommandVO vo = new MealCommandVO(dto);

        Meal meal = Meal.builder()
                .mealDt(LocalDate.parse(vo.getMealDt()))
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
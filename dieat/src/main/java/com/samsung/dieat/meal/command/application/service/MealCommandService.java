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
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealCommandService {

    private final MealJpaRepository mealJpaRepository;
    private final MealFoodJpaRepository mealFoodJpaRepository;


    @Transactional
    public void registerMeal(MealCommandDTO dto) {
        MealCommandVO vo = new MealCommandVO(dto);

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

    @Transactional
    public void updateMeal(int mealCode, MealCommandDTO dto) {

        Meal meal = mealJpaRepository.findById(mealCode)
                .orElseThrow(() -> new RuntimeException("식사 정보가 없습니다."));
        MealCommandVO vo = new MealCommandVO(dto);
        meal.update(vo);

        List<MealFood> existingFoods = mealFoodJpaRepository.findByMealCodeWithMeal(mealCode);

        List<MealCommandVO.MealFoodVO> newFoods = vo.getMealFoods();


        List<MealFood> toDelete = new ArrayList<>();

        for (MealFood existing : existingFoods) {
            boolean matched = false;
            for (MealCommandVO.MealFoodVO incoming : newFoods) {
                if (existing.getMealFoodCode() == incoming.getMealFoodCode()
                        && existing.getMealFoodType() == incoming.getMealFoodType()) {
                    existing.updateCnt(incoming.getMealFoodCnt());
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                toDelete.add(existing);
            }
        }

        // 삭제할 항목 제거
        toDelete.forEach(mealFoodJpaRepository::delete);

        // 추가할 항목 insert
        for (MealCommandVO.MealFoodVO incoming : newFoods) {
            boolean alreadyExists = existingFoods.stream().anyMatch(e ->
                    e.getMealFoodCode() == incoming.getMealFoodCode()
                            && e.getMealFoodType() == incoming.getMealFoodType());

            if (!alreadyExists) {
                MealFood newFood = MealFood.builder()
                        .meal(meal)
                        .mealFoodCode(incoming.getMealFoodCode())
                        .mealFoodType(incoming.getMealFoodType())
                        .mealFoodCnt(incoming.getMealFoodCnt())
                        .build();
                mealFoodJpaRepository.save(newFood);
            }
        }
    }
}
package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MealCommandServiceImpl implements MealCommandService {

    private final MealJpaRepository mealJpaRepository;
    private final MealFoodJpaRepository mealFoodJpaRepository;

    // 식사 등록
    @Override
    public void registerMeal(int authenticatedUserCode, MealCommandDTO dto) {
        Meal meal = Meal.builder()
                .mealDt(dto.getMealDt())
                .mealTitle(dto.getMealTitle())
                .mealDesc(dto.getMealDesc())
                .mealCalories(dto.getMealCalories())
                .mealCarbs(dto.getMealCarbs())
                .mealSugar(dto.getMealSugar())
                .mealProtein(dto.getMealProtein())
                .mealFat(dto.getMealFat())
                .userCode(authenticatedUserCode)
                .build();

        Meal savedMeal = mealJpaRepository.save(meal);

        dto.getMealFoods().forEach(food -> {
            MealFood mealFood = MealFood.builder()
                    .meal(savedMeal)
                    .mealFoodCode(food.getMealFoodCode())
                    .mealFoodType(food.getMealFoodType())
                    .mealFoodCnt(food.getMealFoodCnt())
                    .build();
            mealFoodJpaRepository.save(mealFood);
        });
    }

    // 식사 수정
    @Override
    public void updateMeal(int authenticatedUserCode, int mealCode, MealCommandDTO dto) {
        Meal meal = mealJpaRepository.findById(mealCode)
                .orElseThrow(() -> new RuntimeException("식사 정보가 없습니다."));

        // 권한 확인
        if (meal.getUserCode() != authenticatedUserCode) {
            throw new RuntimeException("이 식사는 다른 사용자의 것입니다. 수정할 권한이 없습니다.");
        }

        meal.update(dto);
    }

    // 식사 삭제
    @Override
    @Transactional
    public void deleteMeal(int authenticatedUserCode, int mealCode) {
        Meal meal = mealJpaRepository.findById(mealCode)
                .orElseThrow(() -> new RuntimeException("식사 정보가 없습니다."));

        if (meal.getUserCode() != authenticatedUserCode) {
            throw new RuntimeException("이 식사는 다른 사용자의 것입니다. 삭제할 권한이 없습니다.");
        }

        // 자식 엔티티 먼저 삭제
        mealFoodJpaRepository.deleteAllByMeal(meal);

        // 부모 삭제
        mealJpaRepository.delete(meal);
    }
}

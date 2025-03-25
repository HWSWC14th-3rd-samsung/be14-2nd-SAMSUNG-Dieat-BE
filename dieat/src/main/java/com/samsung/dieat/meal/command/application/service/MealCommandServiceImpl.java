package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
<<<<<<< HEAD
import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.repository.MealCommandRepository;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
=======
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
@Service
@RequiredArgsConstructor
public class MealCommandServiceImpl implements MealCommandService {

<<<<<<< HEAD
    private final MealCommandRepository mealCommandRepository;
    private final MealJpaRepository mealJpaRepository;
    private final MealFoodJpaRepository mealFoodJpaRepository;

    @Override
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
=======
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
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
                .build();

        Meal savedMeal = mealJpaRepository.save(meal);

<<<<<<< HEAD
        vo.getMealFoods().forEach(f -> {
            MealFood mealFood = MealFood.builder()
                    .meal(savedMeal)
                    .mealFoodCode(f.getMealFoodCode())
                    .mealFoodType(f.getMealFoodType())
                    .mealFoodCnt(f.getMealFoodCnt())
=======
        dto.getMealFoods().forEach(food -> {
            MealFood mealFood = MealFood.builder()
                    .meal(savedMeal)
                    .mealFoodCode(food.getMealFoodCode())
                    .mealFoodType(food.getMealFoodType())
                    .mealFoodCnt(food.getMealFoodCnt())
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
                    .build();
            mealFoodJpaRepository.save(mealFood);
        });
    }

<<<<<<< HEAD
    @Override
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
            if (!matched) toDelete.add(existing);
        }

        toDelete.forEach(mealFoodJpaRepository::delete);

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

    @Override
    @Transactional
    public void deleteMeal(int mealCode) {
        mealFoodJpaRepository.deleteByMeal_MealCode(mealCode);
        mealJpaRepository.deleteById(mealCode);
=======
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
    public void deleteMeal(int authenticatedUserCode, int mealCode) {
        Meal meal = mealJpaRepository.findById(mealCode)
                .orElseThrow(() -> new RuntimeException("식사 정보가 없습니다."));

        MealFood mealfood = mealFoodJpaRepository.findById(mealCode)
                .orElseThrow(() -> new RuntimeException("식사 정보가 없습니다."));



        // 권한 확인
        if (meal.getUserCode() != authenticatedUserCode) {
            throw new RuntimeException("이 식사는 다른 사용자의 것입니다. 삭제할 권한이 없습니다.");
        }

        mealFoodJpaRepository.delete(mealfood);
        mealJpaRepository.delete(meal);
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
    }
}
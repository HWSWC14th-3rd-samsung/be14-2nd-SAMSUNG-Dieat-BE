package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class MealCommandServiceTest {

    @Autowired
    private MealCommandService mealCommandService;

    @Autowired
    private MealJpaRepository mealJpaRepository;

    @Autowired
    private MealFoodJpaRepository mealFoodJpaRepository;

    @Test
    public void 식사_등록_테스트() {
        MealCommandDTO dto = new MealCommandDTO(
                3,
                "2025-01-02 14",
                "닭가슴살 볶음밥",
                "닭가슴살 100g 2봉지, 현미밥 200g, 양배추 1/2개, 간장 1스푼",
                400f, 80f, 3f, 50f, 0f,
                List.of(
                        new MealCommandDTO.MealFoodDTO(1, MealFoodType.OPENDATA, 2),
                        new MealCommandDTO.MealFoodDTO(2, MealFoodType.OPENDATA, 1),
                        new MealCommandDTO.MealFoodDTO(3, MealFoodType.OPENDATA, 1),
                        new MealCommandDTO.MealFoodDTO(4, MealFoodType.OPENDATA, 1)
                )
        );

        mealCommandService.registerMeal(dto);

        Meal savedMeal = mealJpaRepository.findByUserCodeAndMealDt(3, "2025-01-02 14")
                .orElseThrow(() -> new RuntimeException("저장된 식사가 없습니다."));
        var savedFoods = mealFoodJpaRepository.findByMealCodeWithMeal(savedMeal.getMealCode());

        assertThat(savedMeal.getMealTitle()).isEqualTo("닭가슴살 볶음밥");
        assertThat(savedFoods).hasSize(4);
    }

    @Test
    public void 식사_수정_테스트() {
        MealCommandDTO initialDto = new MealCommandDTO(
                3,
                "2025-01-02 15",
                "오트밀과 과일",
                "오트밀 50g, 바나나 1개, 블루베리 30g",
                350f, 60f, 15f, 10f, 5f,
                List.of(new MealCommandDTO.MealFoodDTO(101, MealFoodType.USERDATA, 1))
        );
        mealCommandService.registerMeal(initialDto);
        int mealCode = mealJpaRepository.findByUserCodeAndMealDt(3, "2025-01-02 15").orElseThrow().getMealCode();

        MealCommandDTO updatedDto = new MealCommandDTO(
                3,
                "2025-01-02 15",
                "닭가슴살 볶음밥",
                "닭가슴살 100g 2봉지, 현미밥 200g, 양배추 1/2개, 간장 1스푼",
                500f, 80f, 5f, 60f, 3f,
                List.of(new MealCommandDTO.MealFoodDTO(102, MealFoodType.USERDATA, 2))
        );

        mealCommandService.updateMeal(mealCode, updatedDto);

        var updatedMeal = mealJpaRepository.findById(mealCode).orElseThrow();
        var updatedFoods = mealFoodJpaRepository.findByMealCodeWithMeal(mealCode);

        assertThat(updatedMeal.getMealTitle()).isEqualTo("닭가슴살 볶음밥");
        assertThat(updatedMeal.getMealCalories()).isEqualTo(500f);
        assertThat(updatedFoods).hasSize(1);
        assertThat(updatedFoods.get(0).getMealFoodCode()).isEqualTo(102);
    }

    @Test
    public void 식사_삭제_테스트() {
        MealCommandDTO dto = new MealCommandDTO(
                3,
                "2025-01-02 16",
                "삭제할 식사",
                "테스트용 식사",
                200f, 30f, 2f, 20f, 1f,
                List.of(new MealCommandDTO.MealFoodDTO(201, MealFoodType.OPENDATA, 1))
        );
        mealCommandService.registerMeal(dto);
        int mealCode = mealJpaRepository.findByUserCodeAndMealDt(3, "2025-01-02 16").orElseThrow().getMealCode();

        mealCommandService.deleteMeal(mealCode);

        var deletedMeal = mealJpaRepository.findById(mealCode);
        var deletedFoods = mealFoodJpaRepository.findByMealCodeWithMeal(mealCode);

        assertThat(deletedMeal).isEmpty();
        assertThat(deletedFoods).isEmpty();
    }
}
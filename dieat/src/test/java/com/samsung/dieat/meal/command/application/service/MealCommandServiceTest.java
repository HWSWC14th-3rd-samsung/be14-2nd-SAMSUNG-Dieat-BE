package com.samsung.dieat.meal.command.application.service;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.domain.aggregate.enums.MealFoodType;
import com.samsung.dieat.meal.command.domain.repository.MealJpaRepository;
import com.samsung.dieat.meal.command.domain.repository.MealFoodJpaRepository;
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
    public void 식사_수정_테스트() {
        // given:
        MealCommandDTO.MealFoodDTO food1 = new MealCommandDTO.MealFoodDTO(101, MealFoodType.OPENDATA, 1);
        MealCommandDTO original = new MealCommandDTO(
                2, "2025-03-23", "아침", "오트밀 + 계란",
                400f, 50f, 10f, 25f, 15f,
                List.of(food1)
        );
        mealCommandService.registerMeal(original);
        int mealCode = mealJpaRepository.findAll().get(0).getMealCode();

        // when:
        MealCommandDTO.MealFoodDTO food2 = new MealCommandDTO.MealFoodDTO(102, MealFoodType.USERDATA, 2);
        MealCommandDTO updated = new MealCommandDTO(
                2, "2025-03-23", "수정된 아침", "닭가슴살 + 고구마",
                500f, 60f, 5f, 35f, 10f,
                List.of(food2)
        );

        // then:
        mealCommandService.updateMeal(mealCode, updated);

        var updatedMeal = mealJpaRepository.findById(mealCode).orElseThrow();
        var updatedFoods = mealFoodJpaRepository.findByMealCodeWithMeal(mealCode);

        assertThat(updatedMeal.getMealTitle()).isEqualTo("수정된 아침");
        assertThat(updatedFoods).hasSize(1);
        assertThat(updatedFoods.get(0).getMealFoodCode()).isEqualTo(102);
    }
}
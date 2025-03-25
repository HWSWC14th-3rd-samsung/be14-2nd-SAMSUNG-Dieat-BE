package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealFoodQueryDTO;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class MealQueryServiceTest {

    @Autowired
    private MealQueryService mealQueryService;

    @Test
    void 회원_번호로_해당_회원의_모든_식사를_조회() {
        // given
        int userCode = 1;

        // when
        List<MealQueryDTO> meals = mealQueryService.findMealsByUserCode(userCode);

        // then
        assertThat(meals).isNotNull();
        assertThat(meals).isNotEmpty();

        for (MealQueryDTO meal : meals) {
            assertThat(meal.getUserCode()).isEqualTo(userCode);
            assertThat(meal.getMealFoods()).isNotNull();

            for (MealFoodQueryDTO food : meal.getMealFoods()) {
                assertThat(food.getMealFoodCode()).isNotNull();
                assertThat(food.getMealFoodType()).isNotNull();
                assertThat(food.getMealFoodCnt()).isNotNull();
            }
        }
    }

    @Test
    void 회원_코드와_날짜에_맞는_식사_조회() {
        // given
        MealDefaultSelectCondition condition = new MealDefaultSelectCondition(1, "2024-01-27");

        // when
        List<MealQueryDTO> results = mealQueryService.findMealsDefault(condition);

        // then
        assertThat(results).isNotNull();
        assertThat(results).isNotEmpty();

        MealQueryDTO result = results.get(0);
        assertThat(result.getUserCode()).isEqualTo(1);
        assertThat(result.getMealDt()).isEqualTo("2024-01-27");

        List<MealFoodQueryDTO> mealFoods = result.getMealFoods();
        assertThat(mealFoods).isNotNull();

        for (MealFoodQueryDTO food : mealFoods) {
            assertThat(food.getMealFoodCode()).isNotNull();
            assertThat(food.getMealFoodType()).isNotNull();
            assertThat(food.getMealFoodCnt()).isNotNull();
        }
    }
}
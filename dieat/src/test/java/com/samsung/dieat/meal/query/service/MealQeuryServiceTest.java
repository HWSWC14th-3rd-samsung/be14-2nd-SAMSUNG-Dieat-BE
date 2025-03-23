package com.samsung.dieat.meal.query.service;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
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
        assertThat(meals).allSatisfy(meal -> {
            assertThat(meal.getUserCode()).isEqualTo(userCode);
            assertThat(meal.getMealFoods()).isNotNull();
        });
    }

    @Test
    void 회원_코드와_날짜에_맞는_식사_조회() {
        // given
        MealDefaultSelectCondition condition = new MealDefaultSelectCondition(1, "2024-01-27");

        // when
        MealQueryDTO result = mealQueryService.findMealsDefault(condition);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getUserCode()).isEqualTo(1);
        assertThat(result.getMealDt()).isEqualTo("2024-01-27");
        assertThat(result.getMealFoods()).isNotNull();
    }
}
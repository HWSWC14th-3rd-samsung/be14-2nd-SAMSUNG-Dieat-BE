package com.samsung.dieat.meal.query.controller;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import com.samsung.dieat.meal.query.service.MealQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MealQueryController {

    private final MealQueryService mealQueryService;

    @GetMapping("/meals")
    public List<MealQueryDTO> findMealsByUserCode(@PathVariable int userCode) {
        return mealQueryService.findMealsByUserCode(userCode);
    }

    @GetMapping("/meals/{mealCode}")
    public List<MealQueryDTO> findMealsDefault(@PathVariable int userCode, @PathVariable String mealDt) {
        MealDefaultSelectCondition condition = new MealDefaultSelectCondition(userCode, mealDt);
        return mealQueryService.findMealsDefault(condition);
    }

    @GetMapping("/meals/datelist")
    public List<String> findMealDateListByUserCode(@PathVariable int userCode) {
        return mealQueryService.findMealDateListByUserCode(userCode);
    }

    @GetMapping("/allMeals")
    public List<MealQueryDTO> findAllMeals() {
        return mealQueryService.findAllMeals();
    }
}
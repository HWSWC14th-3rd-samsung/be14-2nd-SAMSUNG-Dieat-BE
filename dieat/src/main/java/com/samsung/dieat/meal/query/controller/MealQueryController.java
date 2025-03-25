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

<<<<<<< HEAD
    @GetMapping("/users/{userCode}/meals")
=======
    @GetMapping("/meals")
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
    public List<MealQueryDTO> findMealsByUserCode(@PathVariable int userCode) {
        return mealQueryService.findMealsByUserCode(userCode);
    }

<<<<<<< HEAD
    @GetMapping("/users/{userCode}/meals/{mealDt}")
=======
    @GetMapping("/meals/{mealCode}")
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
    public List<MealQueryDTO> findMealsDefault(@PathVariable int userCode, @PathVariable String mealDt) {
        MealDefaultSelectCondition condition = new MealDefaultSelectCondition(userCode, mealDt);
        return mealQueryService.findMealsDefault(condition);
    }

<<<<<<< HEAD
    @GetMapping("/users/{userCode}/meals/datelist")
=======
    @GetMapping("/meals/datelist")
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
    public List<String> findMealDateListByUserCode(@PathVariable int userCode) {
        return mealQueryService.findMealDateListByUserCode(userCode);
    }

    @GetMapping("/allMeals")
    public List<MealQueryDTO> findAllMeals() {
        return mealQueryService.findAllMeals();
    }
}
package com.samsung.dieat.meal.query.controller;

import com.samsung.dieat.meal.query.dto.MealDefaultSelectCondition;
import com.samsung.dieat.meal.query.dto.MealQueryDTO;
import com.samsung.dieat.meal.query.service.MealQueryService;
import com.samsung.dieat.security.CustomUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meals")
public class MealQueryController {

    private final MealQueryService mealQueryService;



    @GetMapping
    public ResponseEntity<?> getMyMeals(HttpServletRequest request) {

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
        }

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        List<MealQueryDTO> meals = mealQueryService.getMealsByUserCode(authenticatedUserCode);
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getMealDates(HttpServletRequest request) {

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
        }

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        List<String> mealDates = mealQueryService.getMealDatesByUserCode(authenticatedUserCode);
        return ResponseEntity.ok(mealDates);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchMeals(
            @RequestParam(value = "mealDtLike", required = false) String mealDtLike,
            @RequestParam(value = "keywordList", required = false) String keywordListRaw,
            HttpServletRequest request
    ) {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
        }

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        List<String> keywordList = keywordListRaw != null && !keywordListRaw.isBlank()
                ? Arrays.asList(keywordListRaw.split(","))
                : Collections.emptyList();

        MealDefaultSelectCondition condition = new MealDefaultSelectCondition();
        condition.setUserCode(authenticatedUserCode);
        condition.setMealDtLike(mealDtLike);
        condition.setKeywordList(keywordList);

        List<MealQueryDTO> searchResults = mealQueryService.searchMeals(condition);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/{mealCode}")
    public ResponseEntity<?> getSingleMeal(
            @PathVariable int mealCode,
            HttpServletRequest request
    ) {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
        }

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        MealQueryDTO meal = mealQueryService.getMealByMealCodeAndUserCode(mealCode, authenticatedUserCode);

        if (meal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("식사를 찾을 수 없습니다.");
        }

        return ResponseEntity.ok(meal);
    }
}
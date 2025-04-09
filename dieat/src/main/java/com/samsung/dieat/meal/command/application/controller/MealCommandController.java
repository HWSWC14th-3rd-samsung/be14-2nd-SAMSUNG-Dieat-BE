package com.samsung.dieat.meal.command.application.controller;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.application.service.MealCommandService;
import com.samsung.dieat.security.JwtUtil;
import com.samsung.dieat.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MealCommandController {

    private final MealCommandService mealCommandService;

    @Autowired
    public MealCommandController(MealCommandService mealCommandService) {
        this.mealCommandService = mealCommandService;
    }

    // 식사 등록
    @PostMapping("/meals")
    public ResponseEntity<?> registerMeal(@RequestBody MealCommandDTO dto) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        mealCommandService.registerMeal(authenticatedUserCode, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("식사 등록 완료");
    }

    // 식사 수정
    @PutMapping("/meals/{mealCode}")
    public ResponseEntity<?> updateMeal(@PathVariable int mealCode, @RequestBody MealCommandDTO dto) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        mealCommandService.updateMeal(authenticatedUserCode, mealCode, dto);
        return ResponseEntity.ok("식사 수정 완료");
    }

    // 식사 삭제
    @DeleteMapping("/meals/{mealCode}")
    public ResponseEntity<?> deleteMeal(@PathVariable int mealCode) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int authenticatedUserCode = userDetails.getUserCode();

        mealCommandService.deleteMeal(authenticatedUserCode, mealCode);
        return ResponseEntity.ok("식사 삭제 완료");
    }
}
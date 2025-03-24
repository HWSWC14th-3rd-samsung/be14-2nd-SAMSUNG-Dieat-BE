package com.samsung.dieat.meal.command.application.controller;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.application.service.MealCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MealCommandController {

    private Environment env;

    @Autowired
    private MealCommandService mealCommandService;

    @Autowired
    public MealCommandController(Environment env) {
        this.env = env;
    }

//    @GetMapping("/health")
//    public String healthCheck() {
//        return "서버 잘 돌아가는 중. 접속한 포트: " + env.getProperty("local.server.port");
//    }

//    @GetMapping("/message")
//    public String message(@RequestHeader("first-request") String header) {
//        log.info("넘어온 헤더값: {}", header);
//        return "메세지 넘어왔음";
//    }

    @PostMapping("/users/{userCode}/meals/{mealCode}")
    public ResponseEntity<?> registerMeal(@PathVariable int userCode, @RequestBody MealCommandDTO dto) {
        mealCommandService.registerMeal(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("식사 등록 완료");
    }

    @PutMapping("/users/{userCode}/meals/{mealCode}")
    public ResponseEntity<?> updateMeal(@PathVariable int mealCode, @RequestBody MealCommandDTO dto) {
        mealCommandService.updateMeal(mealCode, dto);
        return ResponseEntity.ok("식사 수정 완료");
    }

    @DeleteMapping("/users/{userCode}/meals/{mealCode}")
    public ResponseEntity<?> deleteMeal(@PathVariable int userCode, @PathVariable int mealCode) {
        mealCommandService.deleteMeal(mealCode);
        return ResponseEntity.ok("식사 삭제 완료");
    }
}

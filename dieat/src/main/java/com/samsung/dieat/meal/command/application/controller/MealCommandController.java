package com.samsung.dieat.meal.command.application.controller;

import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import com.samsung.dieat.meal.command.application.service.MealCommandService;
<<<<<<< HEAD
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
=======
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
    private final JwtUtil jwtUtil;

    @Autowired
    public MealCommandController(MealCommandService mealCommandService, JwtUtil jwtUtil) {
        this.mealCommandService = mealCommandService;
        this.jwtUtil = jwtUtil;
    }

    // 식사 등록
    @PostMapping("/meals")
    public ResponseEntity<?> registerMeal(@RequestBody MealCommandDTO dto, HttpServletRequest request) {
        // JWT 토큰에서 유저 정보 추출
        String token = request.getHeader("Authorization").substring(7); // Bearer <token>
        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int authenticatedUserCode = userDetails.getUserCode(); // 인증된 유저의 userCode 가져오기

            // 인증된 userCode와 MealCommandDTO를 사용하여 등록 처리
            mealCommandService.registerMeal(authenticatedUserCode, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("식사 등록 완료");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }

    // 식사 수정
    @PutMapping("/meals/{mealCode}")
    public ResponseEntity<?> updateMeal(@PathVariable int mealCode, @RequestBody MealCommandDTO dto, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7); // Bearer <token>
        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int authenticatedUserCode = userDetails.getUserCode();

            // mealCode와 인증된 userCode를 사용하여 수정 처리
            mealCommandService.updateMeal(authenticatedUserCode, mealCode, dto);
            return ResponseEntity.ok("식사 수정 완료");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }

    // 식사 삭제
    @DeleteMapping("/meals/{mealCode}")
    public ResponseEntity<?> deleteMeal(@PathVariable int mealCode, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7); // Bearer <token>
        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int authenticatedUserCode = userDetails.getUserCode();

            // mealCode와 인증된 userCode를 사용하여 삭제 처리
            mealCommandService.deleteMeal(authenticatedUserCode, mealCode);
            return ResponseEntity.ok("식사 삭제 완료");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }
}
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49

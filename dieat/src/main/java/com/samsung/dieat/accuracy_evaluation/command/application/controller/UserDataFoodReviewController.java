package com.samsung.dieat.accuracy_evaluation.command.application.controller;

import com.samsung.dieat.accuracy_evaluation.command.application.dto.UserDataFoodReviewRequest;
import com.samsung.dieat.accuracy_evaluation.command.entity.ReviewType;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReview;
import com.samsung.dieat.accuracy_evaluation.command.application.service.UserDataFoodReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-data-food-review")
@RequiredArgsConstructor
public class UserDataFoodReviewController {

    private final UserDataFoodReviewService reviewService;

    @PostMapping("/accurate")
    public ResponseEntity<UserDataFoodReview> createAccurateReview(
            @RequestBody UserDataFoodReviewRequest request) {
        // 요청 바디의 rvwUserCode와 udfCode로 리뷰 생성, ReviewType은 ACCURATE로 고정
        UserDataFoodReview review = reviewService.createReview(request, ReviewType.ACCURATE);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @PostMapping("/inaccurate")
    public ResponseEntity<UserDataFoodReview> createInaccurateReview(
            @RequestBody UserDataFoodReviewRequest request) {

        UserDataFoodReview review = reviewService.createReview(request, ReviewType.INACCURATE);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReview(@RequestBody UserDataFoodReviewRequest request) {
        reviewService.deleteReview(request);
        return ResponseEntity.noContent().build();
    }
}

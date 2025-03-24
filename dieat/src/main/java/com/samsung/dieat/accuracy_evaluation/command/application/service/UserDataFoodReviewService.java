package com.samsung.dieat.accuracy_evaluation.command.application.service;

import com.samsung.dieat.accuracy_evaluation.command.application.dto.UserDataFoodReviewRequest;
import com.samsung.dieat.accuracy_evaluation.command.entity.ReviewType;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReview;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReviewId;
import com.samsung.dieat.accuracy_evaluation.command.infrastructure.UserDataFoodReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataFoodReviewService {

    private final UserDataFoodReviewRepository repository;

    public UserDataFoodReview createReview(UserDataFoodReviewRequest request, ReviewType reviewType) {
        UserDataFoodReviewId id = new UserDataFoodReviewId(request.getRvwUserCode(), request.getUdfCode());
        UserDataFoodReview review = UserDataFoodReview.builder()
                .id(id)
                .rvwType(reviewType)
                .build();
        return repository.save(review);
    }
}

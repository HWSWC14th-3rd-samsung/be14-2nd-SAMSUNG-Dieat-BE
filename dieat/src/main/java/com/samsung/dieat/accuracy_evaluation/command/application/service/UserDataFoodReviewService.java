package com.samsung.dieat.accuracy_evaluation.command.application.service;

import com.samsung.dieat.accuracy_evaluation.command.application.dto.UserDataFoodReviewRequest;
import com.samsung.dieat.accuracy_evaluation.command.entity.ReviewType;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReview;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReviewId;
import com.samsung.dieat.accuracy_evaluation.command.infrastructure.UserDataFoodReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void deleteReview(UserDataFoodReviewRequest request) {
        // 복합키 생성
        UserDataFoodReviewId id = new UserDataFoodReviewId(request.getRvwUserCode(), request.getUdfCode());
        // 존재 여부 확인 후 삭제 (필요 시 추가 검증 가능)
        repository.deleteById(id);
    }
}

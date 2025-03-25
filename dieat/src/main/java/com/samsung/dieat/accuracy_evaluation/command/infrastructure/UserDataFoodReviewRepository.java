package com.samsung.dieat.accuracy_evaluation.command.infrastructure;

import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReview;
import com.samsung.dieat.accuracy_evaluation.command.entity.UserDataFoodReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataFoodReviewRepository extends JpaRepository<UserDataFoodReview, UserDataFoodReviewId> {
}

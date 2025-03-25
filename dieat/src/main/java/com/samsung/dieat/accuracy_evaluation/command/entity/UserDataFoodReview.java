package com.samsung.dieat.accuracy_evaluation.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user_data_food_review")
public class UserDataFoodReview {

    @EmbeddedId
    private UserDataFoodReviewId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rvw_type", nullable = false)
    private ReviewType rvwType;
}

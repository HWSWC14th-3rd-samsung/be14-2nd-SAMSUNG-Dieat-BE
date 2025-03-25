package com.samsung.dieat.accuracy_evaluation.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class UserDataFoodReviewId implements Serializable {

    @Column(name = "rvw_user_code")
    private int rvwUserCode;

    @Column(name = "udf_code")
    private int udfCode;
}

package com.samsung.dieat.like.command.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_like")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {

    @EmbeddedId
    private LikeId id;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class LikeId implements Serializable {

        @Column(name = "likes_target_code", nullable = false)
        private int likesTargetCode;

        @Enumerated(EnumType.STRING)
        @Column(name = "likes_target_type", nullable = false)
        private LikesTargetType likesTargetType;

        @Column(name = "user_code", nullable = false)
        private int userCode;
    }
}

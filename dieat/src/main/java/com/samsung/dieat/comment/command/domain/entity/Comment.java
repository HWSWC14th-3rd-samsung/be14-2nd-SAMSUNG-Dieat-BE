package com.samsung.dieat.comment.command.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_code")
    private int cmtCode;

    @Column(name = "cmt_conts", nullable = false, length = 255)
    private String cmtConts;

    @Column(name = "cmt_created_dt", nullable = false)
    private LocalDateTime cmtCreatedDt;

    @Column(name = "cmt_updated_dt")
    private LocalDateTime cmtUpdatedDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "cmt_target_type", nullable = false)
    private CommentTargetType cmtTargetType;

    @Column(name = "cmt_target_code", nullable = false)
    private int cmtTargetCode;

    @Column(name = "cmt_isdeleted", nullable = false)
    private boolean cmtIsDeleted;

    @Column(name = "user_code", nullable = false)
    private int userCode;
}

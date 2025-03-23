package com.samsung.dieat.success_post.command.domain.aggregate.entity;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tbl_success_post")
public class SuccessPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "succ_code")
    private int succCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code", nullable = false)                   // 포인트 적립 받는 회원 코드
    private UserEntity userCode;

    @Column(name = "succ_title", nullable = false, length = 255)
    private String succTitle;

    @Column(name = "succ_conts", nullable = false)
    private String succConts;

    @Column(name = "succ_created_dt", nullable = false)
    private LocalDateTime succCreatedDt = LocalDateTime.now();

    @Column(name = "succ_view_cnt", nullable = false)
    private int succViewCnt = 0;

    @Column(name = "succ_like_cnt", nullable = false)
    private int succLikeCnt = 0;

    @Column(name = "succ_cmt_cnt", nullable = false)
    private int succCmtCnt = 0;

    @Column(name = "succ_term", nullable = false, length = 50)
    private String succTerm;

    @Column(name = "succ_isdeleted", nullable = false)
    private boolean succIsdeleted = Boolean.FALSE;
}

package com.samsung.dieat.notice_post.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_notice_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noti_code")
    private Integer notiCode;

    @Column(name = "noti_title", nullable = false)
    private String notiTitle;

    @Column(name = "noti_conts", nullable = false, columnDefinition = "TEXT")
    private String notiConts;

    @Column(name = "noti_created_dt", nullable = false)
    private LocalDateTime notiCreatedDt;

    @Column(name = "noti_view_cnt", nullable = false)
    private int notiViewCnt = 0;

    @Column(name = "noti_updated_dt")
    private LocalDateTime notiUpdatedDt;
}

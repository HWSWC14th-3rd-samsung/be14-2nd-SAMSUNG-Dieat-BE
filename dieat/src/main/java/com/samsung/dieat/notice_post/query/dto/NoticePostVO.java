package com.samsung.dieat.notice_post.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticePostVO {
    private Integer notiCode;
    private String notiTitle;
    private String notiConts;
    private LocalDateTime notiCreatedDt;
    private Integer notiViewCnt;
    private LocalDateTime notiUpdatedDt;
}

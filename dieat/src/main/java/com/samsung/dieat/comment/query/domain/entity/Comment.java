package com.samsung.dieat.comment.query.domain.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private int cmtCode;
    private String cmtConts;
    private LocalDateTime cmtCreatedDt;
    private LocalDateTime cmtUpdatedDt;
    private String cmtTargetType; // 'FREE', 'DIET', 'SUCCESS'
    private int cmtTargetCode;
    private boolean cmtIsDeleted;
    private int userCode;
}

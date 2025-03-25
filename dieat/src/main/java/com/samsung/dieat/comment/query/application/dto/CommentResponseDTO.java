package com.samsung.dieat.comment.query.application.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentResponseDTO {
    private int cmtCode;
    private String cmtConts;
    private LocalDateTime cmtCreatedDt;
    private LocalDateTime cmtUpdatedDt;
    private String cmtTargetType;
    private int cmtTargetCode;
    private int userCode;
}

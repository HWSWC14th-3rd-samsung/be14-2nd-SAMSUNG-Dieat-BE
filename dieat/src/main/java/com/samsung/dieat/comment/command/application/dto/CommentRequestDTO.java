package com.samsung.dieat.comment.command.application.dto;

import com.samsung.dieat.comment.command.domain.entity.CommentTargetType;
import lombok.Data;

@Data
public class CommentRequestDTO {
    private String cmtConts;
    private CommentTargetType cmtTargetType;
    private int cmtTargetCode;
    private int userCode;
}

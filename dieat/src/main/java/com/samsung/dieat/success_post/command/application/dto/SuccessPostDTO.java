package com.samsung.dieat.success_post.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SuccessPostDTO {
    private int succCode;
    private int userCode;
    private String succTitle;
    private String succConts;
    private LocalDateTime succCreatedDt;
    private int succViewCnt;
    private int succLikeCnt;
    private int succCmtCnt;
    private String succTerm;
    private boolean succIsdeleted;


}

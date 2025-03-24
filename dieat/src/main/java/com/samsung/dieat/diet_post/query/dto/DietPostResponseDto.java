package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DietPostResponseDto {
    private int dietCode;
    private LocalDateTime dietUploadDt;
    private String dietTitle;
    private String dietConts;
    private int dietViewCnt;
    private int dietLikeCnt;
    private int dietCmtCnt;
    private float dietCalories;
    private float dietCarbs;
    private float dietSugar;
    private float dietProtein;
    private float dietFat;
    private boolean dietIsDeleted;
    private int userCode;
}

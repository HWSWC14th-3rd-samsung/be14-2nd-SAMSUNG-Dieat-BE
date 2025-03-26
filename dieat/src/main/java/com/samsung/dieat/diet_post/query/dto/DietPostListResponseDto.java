package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietPostListResponseDto {
    private int dietCode;
    private String dietTitle;
    private float dietCalories;
    private float dietCarbs;
    private float dietSugar;
    private float dietProtein;
    private float dietFat;
    private int dietViewCnt;
    private String dietUploadDt;
    private String userNickname;
}


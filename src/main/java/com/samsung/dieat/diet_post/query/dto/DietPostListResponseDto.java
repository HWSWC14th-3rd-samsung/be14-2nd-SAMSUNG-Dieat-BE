package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietPostListResponseDto {
    private int dietCode;
    private String dietTitle;
    private String dietConts;
    private float dietCalories;
    private int dietViewCnt;
    private String dietUploadDt;
}

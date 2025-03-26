package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DietPostDetailResponseDto {
    private int dietCode;
    private String dietTitle;
    private String dietConts;
    private float dietCalories;
    private int dietViewCnt;
    private String dietUploadDt;
    private String userNickname;
    private List<DietPostFoodDto> foodList;
}



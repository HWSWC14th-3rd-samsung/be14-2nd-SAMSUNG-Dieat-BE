package com.samsung.dieat.diet_post.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DietPostResponseDto {
    private int dietCode;
    private String dietTitle;
    private String dietConts;
    private float dietCalories;
    private float dietCarbs;
    private float dietSugar;
    private float dietProtein;
    private float dietFat;
    private int userCode;
    private LocalDateTime dietUploadDt;
}

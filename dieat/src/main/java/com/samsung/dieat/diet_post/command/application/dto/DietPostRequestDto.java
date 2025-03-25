package com.samsung.dieat.diet_post.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DietPostRequestDto {
    private LocalDateTime dietUploadDt;
    private String dietTitle;
    private String dietConts;
    private float dietCalories;
    private float dietCarbs;
    private float dietSugar;
    private float dietProtein;
    private float dietFat;
    private int userCode;
}

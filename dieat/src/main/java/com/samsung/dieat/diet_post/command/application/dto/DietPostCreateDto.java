package com.samsung.dieat.diet_post.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DietPostCreateDto {
    private String dietTitle;
    private String dietConts;
    private float dietCalories;
    private float dietCarbs;
    private float dietSugar;
    private float dietProtein;
    private float dietFat;
    private int userCode;
}

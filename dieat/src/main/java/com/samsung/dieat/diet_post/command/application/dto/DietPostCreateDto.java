package com.samsung.dieat.diet_post.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietPostCreateDto {
    private String dietTitle;
    private String dietConts;
    private int dietCalories;
    private int dietCarbs;
    private int dietProtein;
    private int dietFat;
    private int dietSugar;
    private int userCode;
}

package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NutrientSearchConditionDto {
    private Float minCalories;
    private Float maxCalories;
    private Float minProtein;
    private Float maxProtein;
    private Float minCarbs;
    private Float maxCarbs;
    private Float minFat;
    private Float maxFat;
    private Float minSugar;
    private Float maxSugar;
}

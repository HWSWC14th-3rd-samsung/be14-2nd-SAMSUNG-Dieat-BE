package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietPostFoodDto {
    private String foodName;
    private String foodType; // "OPENDATA" or "USERDATA"
    private int foodCount;
    private float calories;
    private float carbs;
    private float sugar;
    private float protein;
    private float fat;
}



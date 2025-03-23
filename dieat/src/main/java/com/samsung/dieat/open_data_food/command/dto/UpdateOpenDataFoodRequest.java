package com.samsung.dieat.open_data_food.command.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class UpdateOpenDataFoodRequest {
    private Integer code;
    private String name;
    private Float calories;
    private Float carbs;
    private Float sugar;
    private Float protein;
    private Float fat;
}
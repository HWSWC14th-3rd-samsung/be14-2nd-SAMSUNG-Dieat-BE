package com.samsung.dieat.open_data_food.command.dto;

import lombok.Data;
import lombok.Getter;

//@Data
@Getter
public class InsertOpenDataFoodResponse {
    private Integer code;
    private String message;

    public InsertOpenDataFoodResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
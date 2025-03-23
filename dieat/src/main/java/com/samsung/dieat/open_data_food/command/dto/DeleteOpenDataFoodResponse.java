package com.samsung.dieat.open_data_food.command.dto;

import lombok.Data;
import lombok.Getter;

//@Data
@Getter
public class DeleteOpenDataFoodResponse {
    private String message;

    public DeleteOpenDataFoodResponse(String message) {
        this.message = message;
    }
}
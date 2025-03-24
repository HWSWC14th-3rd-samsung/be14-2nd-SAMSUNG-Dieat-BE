package com.samsung.dieat.open_data_food.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsertOpenDataFoodResponse {
    private Integer odfCode;
    private String odfMessage;
}
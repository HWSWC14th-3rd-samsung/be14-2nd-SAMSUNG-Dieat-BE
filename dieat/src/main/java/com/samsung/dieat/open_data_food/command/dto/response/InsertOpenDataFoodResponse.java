package com.samsung.dieat.open_data_food.command.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InsertOpenDataFoodResponse {
    private Integer odfCode;
    private String odfMessage;
}
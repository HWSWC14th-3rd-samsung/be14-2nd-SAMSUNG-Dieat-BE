package com.samsung.dieat.open_data_food.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateOpenDataFoodRequest {
    private Integer odfCode;
    private String odfName;
    private Float odfCalories;
    private Float odfCarbs;
    private Float odfSugar;
    private Float odfProtein;
    private Float odfFat;
}
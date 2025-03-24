package com.samsung.dieat.open_data_food.command.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsertOpenDataFoodRequest {

    @NotNull
    private String odfName;

    private Float odfCalories;

    private Float odfCarbs;

    private Float odfSugar;

    private Float odfProtein;

    private Float odfFat;
}
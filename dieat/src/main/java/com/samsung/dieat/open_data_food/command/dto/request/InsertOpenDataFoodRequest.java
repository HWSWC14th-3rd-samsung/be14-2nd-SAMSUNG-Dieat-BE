package com.samsung.dieat.open_data_food.command.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertOpenDataFoodRequest {

    @NotNull
    private String odfName;

    private Float odfCalories;
    private Float odfCarbs;
    private Float odfSugar;
    private Float odfProtein;
    private Float odfFat;
}
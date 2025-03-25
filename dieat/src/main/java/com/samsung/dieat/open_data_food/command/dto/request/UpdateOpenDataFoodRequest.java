package com.samsung.dieat.open_data_food.command.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOpenDataFoodRequest {

    private Integer odfCode;
    private String odfName;

    private Float odfCalories;
    private Float odfCarbs;
    private Float odfSugar;
    private Float odfProtein;
    private Float odfFat;
}
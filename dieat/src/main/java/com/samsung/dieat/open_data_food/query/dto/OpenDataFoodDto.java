package com.samsung.dieat.open_data_food.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OpenDataFoodDto {
    private Integer odfCode;
    private String odfName;
    private Float odfCalories;
    private Float odfCarbs;
    private Float odfProtein;
    private Float odfFat;
    private Float odfSugar;
    private LocalDateTime odfUpdateDt;
}
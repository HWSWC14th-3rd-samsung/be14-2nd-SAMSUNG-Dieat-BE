package com.samsung.dieat.user_data_food.command.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class InsertUserDataFoodResponse {

    private String udfName;

    private Integer udfSvSize;

    private String udfUom;

    private String udfSvUnit;

    private Float udfCalories;

    private Float udfCarbs;

    private Float udfSugar;

    private Float udfProtein;

    private Float udfFat;

    private Integer userCode;

}

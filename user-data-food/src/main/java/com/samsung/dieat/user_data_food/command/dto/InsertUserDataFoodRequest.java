package com.samsung.dieat.user_data_food.command.dto;

import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class InsertUserDataFoodRequest {

    @NotNull
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

    public static UserDataFood toEntity(InsertUserDataFoodRequest request) {
        return UserDataFood.builder()
                .udfName(request.getUdfName())
                .udfSvSize(request.getUdfSvSize())
                .udfUom(request.getUdfUom())
                .udfSvUnit(request.getUdfSvUnit())
                .udfCalories(request.getUdfCalories())
                .udfCarbs(request.getUdfCarbs())
                .udfSugar(request.getUdfSugar())
                .udfProtein(request.getUdfProtein())
                .udfFat(request.getUdfFat())
                .userCode(request.getUserCode())
                .udfAccCnt(0)
                .udfInaccCnt(0)
                .build();
    }

}

package com.samsung.dieat.user_data_food.query.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserDataFoodDTO {
    private int udfCode;
    private String udfName;
    private String udfSvSize;
    private String udfUom;
    private String udfSvUnit;
    private float udfCalories;
    private Float udfCarbs;
    private Float udfProtein;
    private Float udfFat;
    private Float udfSugar;
    private int udfAccCnt;
    private int udfInaccCnt;
    private LocalDateTime udfCreatedDt;
    private int userCode;
}

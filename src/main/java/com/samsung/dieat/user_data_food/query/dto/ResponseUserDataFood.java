package com.samsung.dieat.user_data_food.query.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResponseUserDataFood {
    private String udfName;
    private int udfSvSize;
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
    private String userNickname;  // user_nickname 추가
}

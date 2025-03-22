package com.samsung.dieat.open_data_food.command.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OpenDataFoodDto {
    private Integer odfCode; // 수정/삭제 시 사용
    private String odfName;
    private Float odfCalories;
    private Float odfCarbs;
    private Float odfProtein;
    private Float odfFat;
    private Float odfSugar;
    private LocalDateTime odfUpdateDt;
}
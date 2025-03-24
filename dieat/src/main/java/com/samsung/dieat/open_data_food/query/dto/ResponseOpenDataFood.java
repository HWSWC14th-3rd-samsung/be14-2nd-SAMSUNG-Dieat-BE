package com.samsung.dieat.open_data_food.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseOpenDataFood {
    private Integer odfCode;
    private String odfName;
    private Float odfCalories;
    private Float odfCarbs;
    private Float odfSugar;
    private Float odfProtein;
    private Float odfFat;
    private LocalDateTime odfUpdateDt;
}
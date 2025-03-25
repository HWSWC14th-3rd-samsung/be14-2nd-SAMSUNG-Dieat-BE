package com.samsung.dieat.open_data_food.query.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
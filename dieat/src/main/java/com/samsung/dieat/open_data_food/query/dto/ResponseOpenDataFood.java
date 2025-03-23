package com.samsung.dieat.open_data_food.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseOpenDataFood {
    private Integer code;
    private String name;
    private Float calories;
    private Float carbs;
    private Float sugar;
    private Float protein;
    private Float fat;
    private LocalDateTime updateDate;
}
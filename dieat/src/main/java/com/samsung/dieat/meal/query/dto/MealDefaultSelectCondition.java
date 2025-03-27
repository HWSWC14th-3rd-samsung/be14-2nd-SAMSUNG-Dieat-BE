package com.samsung.dieat.meal.query.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MealDefaultSelectCondition {
    private int userCode;
    private String mealDtLike;
    private List<String> keywordList;
}
package com.samsung.dieat.bookmark_category.command.domain.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseRegistCategoryVO {
    int categoryCode;
    String categoryName;
}

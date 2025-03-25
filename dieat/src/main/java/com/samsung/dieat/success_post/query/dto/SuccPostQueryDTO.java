package com.samsung.dieat.success_post.query.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SuccPostQueryDTO {
    private int succCode;
    private int userCode;
    private String succTitle;
    private String succConts;
    private LocalDateTime succCreatedDt;
    private String succTerm;
}

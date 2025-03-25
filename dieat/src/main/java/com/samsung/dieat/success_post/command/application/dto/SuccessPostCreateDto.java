package com.samsung.dieat.success_post.command.application.dto;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SuccessPostCreateDto {
    private int userCode;
    private String succTitle;
    private String succConts;
    private String succTerm;
}

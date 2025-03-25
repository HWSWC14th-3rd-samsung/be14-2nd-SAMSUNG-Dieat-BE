package com.samsung.dieat.like.command.domain.dto;


import com.samsung.dieat.like.command.domain.entity.LikesTargetType;
import lombok.Data;

@Data
public class LikeRequestDTO {
    private int likesTargetCode;
    private LikesTargetType targetType;
    private int userCode;
}

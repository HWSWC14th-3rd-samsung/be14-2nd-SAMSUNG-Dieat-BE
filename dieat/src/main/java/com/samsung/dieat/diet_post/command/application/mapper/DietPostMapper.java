package com.samsung.dieat.diet_post.command.application.mapper;

import com.samsung.dieat.diet_post.command.application.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DietPostMapper {
    DietPostResponseDto toResponseDto(DietPost dietPost);
}

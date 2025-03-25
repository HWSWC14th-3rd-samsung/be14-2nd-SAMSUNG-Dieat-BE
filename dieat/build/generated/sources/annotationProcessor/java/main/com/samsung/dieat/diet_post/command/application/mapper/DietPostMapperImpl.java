package com.samsung.dieat.diet_post.command.application.mapper;

import com.samsung.dieat.diet_post.command.application.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T16:53:42+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.14 (Homebrew)"
)
@Component
public class DietPostMapperImpl implements DietPostMapper {

    @Override
    public DietPostResponseDto toResponseDto(DietPost dietPost) {
        if ( dietPost == null ) {
            return null;
        }

        DietPostResponseDto dietPostResponseDto = new DietPostResponseDto();

        dietPostResponseDto.setDietCode( dietPost.getDietCode() );
        dietPostResponseDto.setDietTitle( dietPost.getDietTitle() );
        dietPostResponseDto.setDietConts( dietPost.getDietConts() );
        dietPostResponseDto.setDietCalories( dietPost.getDietCalories() );
        dietPostResponseDto.setDietCarbs( dietPost.getDietCarbs() );
        dietPostResponseDto.setDietSugar( dietPost.getDietSugar() );
        dietPostResponseDto.setDietProtein( dietPost.getDietProtein() );
        dietPostResponseDto.setDietFat( dietPost.getDietFat() );
        dietPostResponseDto.setUserCode( dietPost.getUserCode() );
        dietPostResponseDto.setDietUploadDt( dietPost.getDietUploadDt() );

        return dietPostResponseDto;
    }
}

package com.samsung.dieat.diet_post.query.dao;

import com.samsung.dieat.diet_post.query.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DietPostQueryMapper {
    List<DietPostListResponseDto> findAll();
    DietPostResponseDto findById(int dietCode);

    /* 설명. 영양소로 조회 */
    List<DietPostResponseDto> searchByNutrients(NutrientSearchRequestDto dto);
    List<DietPostListResponseDto> searchDietPosts(Map<String, Object> params);


    /* 설명. 페이지네이션 조회 추가 */
    List<DietPostListResponseDto> findAllWithPaging(PageRequestDto pageRequestDto);

    /* 설명. 게시글 총 개수 조회 */
    int countAll();

    DietPostDetailResponseDto findDietPostDetailById(int dietCode);
    List<DietPostFoodDto> findFoodsByDietCode(int dietCode);
    DietPostDetailResponseDto findDetailById(int dietCode);

}
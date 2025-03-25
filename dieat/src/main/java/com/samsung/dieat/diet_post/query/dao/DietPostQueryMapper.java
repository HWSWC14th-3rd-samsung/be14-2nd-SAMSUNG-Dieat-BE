package com.samsung.dieat.diet_post.query.dao;

import com.samsung.dieat.diet_post.query.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.query.dto.DietPostListResponseDto;
import com.samsung.dieat.diet_post.query.dto.PageRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DietPostQueryMapper {
    List<DietPostResponseDto> findAll();
    DietPostResponseDto findById(int dietCode);

    /* 설명. 페이지네이션 조회 추가 */
    List<DietPostListResponseDto> findAllWithPaging(PageRequestDto pageRequestDto);

    /* 설명. 게시글 총 개수 조회 */
    int countAll();
}
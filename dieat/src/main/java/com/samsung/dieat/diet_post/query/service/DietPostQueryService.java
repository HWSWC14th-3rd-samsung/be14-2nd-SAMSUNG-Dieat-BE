package com.samsung.dieat.diet_post.query.service;

import com.samsung.dieat.diet_post.query.dao.DietPostQueryMapper;
import com.samsung.dieat.diet_post.query.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.query.dto.DietPostListResponseDto;
import com.samsung.dieat.diet_post.query.dto.PageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DietPostQueryService {

    private final DietPostQueryMapper dietPostQueryMapper;

    /* 설명. 전체 게시물 조회 */
    public List<DietPostResponseDto> getAllDietPosts() {
        return dietPostQueryMapper.findAll();
    }

    /* 설명. 특정 게시물 조회 */
    public DietPostResponseDto getDietPostById(int dietCode) {
        return dietPostQueryMapper.findById(dietCode);
    }

    /* 설명. 페이징 처리된 전체 게시물 조회 */
    public Map<String, Object> getAllDietPostsWithPaging(PageRequestDto requestDto) {
        List<DietPostListResponseDto> posts = dietPostQueryMapper.findAllWithPaging(requestDto);
        int totalCount = dietPostQueryMapper.countAll();

        Map<String, Object> result = new HashMap<>();
        result.put("content", posts);
        result.put("totalCount", totalCount);
        result.put("page", requestDto.getPage());
        result.put("size", requestDto.getSize());

        return result;
    }
}

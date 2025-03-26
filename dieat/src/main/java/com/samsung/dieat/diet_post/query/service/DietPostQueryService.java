package com.samsung.dieat.diet_post.query.service;

import com.samsung.dieat.diet_post.query.dao.DietPostQueryMapper;
import com.samsung.dieat.diet_post.query.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DietPostQueryService {

    private final DietPostQueryMapper dietPostQueryMapper;

    /* 설명. 전체 게시물 조회 */
    public List<DietPostListResponseDto> getAllDietPosts() {
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

    /* 설명. 영양소 범위로 조회 */
    public List<DietPostResponseDto> searchByNutrients(NutrientSearchRequestDto dto) {
        return dietPostQueryMapper.searchByNutrients(dto);
    }

    public DietPostDetailResponseDto getDietPostDetailById(int dietCode) {
        return dietPostQueryMapper.findDetailById(dietCode);
    }

    public List<DietPostListResponseDto> searchDietPosts(String titleKeyword, NutrientSearchConditionDto condition) {
        Map<String, Object> params = new HashMap<>();

        // 식단 키워드 분리 (공백 기준)
        if (titleKeyword != null && !titleKeyword.trim().isEmpty()) {
            String[] words = titleKeyword.trim().split("\\s+");
            params.put("keywords", Arrays.asList(words));
        }

        // 영양소 조건 매핑
        params.put("minCalories", condition.getMinCalories());
        params.put("maxCalories", condition.getMaxCalories());
        params.put("minProtein", condition.getMinProtein());
        params.put("maxProtein", condition.getMaxProtein());
        params.put("minCarbs", condition.getMinCarbs());
        params.put("maxCarbs", condition.getMaxCarbs());
        params.put("minFat", condition.getMinFat());
        params.put("maxFat", condition.getMaxFat());
        params.put("minSugar", condition.getMinSugar());
        params.put("maxSugar", condition.getMaxSugar());

        return dietPostQueryMapper.searchDietPosts(params);
    }



}

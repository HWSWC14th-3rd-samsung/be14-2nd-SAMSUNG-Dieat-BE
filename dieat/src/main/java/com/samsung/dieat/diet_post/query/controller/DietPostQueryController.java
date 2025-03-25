package com.samsung.dieat.diet_post.query.controller;

import com.samsung.dieat.diet_post.query.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.query.dto.PageRequestDto;
import com.samsung.dieat.diet_post.query.service.DietPostQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diet-posts")
@RequiredArgsConstructor
public class DietPostQueryController {

    private final DietPostQueryService dietPostQueryService;

    /* 설명. 전체 게시물 조회 */
    @GetMapping("/all")
    public ResponseEntity<List<DietPostResponseDto>> getAllDietPosts() {
        return ResponseEntity.ok(dietPostQueryService.getAllDietPosts());
    }

    /* 설명. 단일 게시물 상세 조회 */
    @GetMapping("/{dietCode}")
    public ResponseEntity<DietPostResponseDto> getDietPostById(@PathVariable int dietCode) {
        return ResponseEntity.ok(dietPostQueryService.getDietPostById(dietCode));
    }

    @GetMapping
    public Map<String, Object> getAllDietPosts(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        PageRequestDto dto = new PageRequestDto();
        dto.setPage(page);
        dto.setSize(size);
        return dietPostQueryService.getAllDietPostsWithPaging(dto);
    }


    /* 설명. 영양소 범위로 조회 */
    @PostMapping("/search/nutrients")
    public ResponseEntity<List<DietPostResponseDto>> searchByNutrients(@RequestBody NutrientSearchRequestDto dto) {
        return ResponseEntity.ok(dietPostQueryService.searchByNutrients(dto));
    }

}

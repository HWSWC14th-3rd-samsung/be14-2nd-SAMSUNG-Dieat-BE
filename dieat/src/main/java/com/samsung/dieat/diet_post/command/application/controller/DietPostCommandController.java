package com.samsung.dieat.diet_post.command.application.controller;

import com.samsung.dieat.diet_post.command.application.dto.DietPostCreateDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostUpdateDto;
import com.samsung.dieat.diet_post.command.application.service.DietPostCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diet-posts")
@RequiredArgsConstructor
public class DietPostCommandController {

    private final DietPostCommandService dietPostCommandService;

    /**
     * 식단 게시물 등록
     */
    @PostMapping
    public ResponseEntity<?> createDietPost(@RequestBody DietPostCreateDto dto) {
        return ResponseEntity.ok(dietPostCommandService.createDietPost(dto));
    }

    /**
     * 식단 게시물 수정
     */
    @PutMapping("/{dietCode}")
    public ResponseEntity<?> updateDietPost(@PathVariable long dietCode, @RequestBody DietPostUpdateDto dto) {
        return ResponseEntity.ok(dietPostCommandService.updateDietPost(dietCode, dto));
    }

    /**
     * 식단 게시물 삭제 (소프트 삭제)
     */
    @DeleteMapping("/{dietCode}")
    public ResponseEntity<?> deleteDietPost(@PathVariable long dietCode) {
        dietPostCommandService.deleteDietPost(dietCode);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}

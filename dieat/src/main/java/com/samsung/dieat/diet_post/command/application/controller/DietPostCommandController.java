package com.samsung.dieat.diet_post.command.application.controller;

import com.samsung.dieat.diet_post.command.application.dto.DietPostCreateDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostRequestDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.command.application.service.DietPostCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diet-posts")
@RequiredArgsConstructor
public class DietPostCommandController {

    private final DietPostCommandService dietPostCommandService;

    /* 설명. 게시물 등록 */
    @PostMapping
    public ResponseEntity<DietPostResponseDto> createDietPost(@RequestBody DietPostCreateDto dto) {
        return ResponseEntity.ok(dietPostCommandService.createDietPost(dto));
    }

    /* 설명. 게시물 수정 */
    @PutMapping("/{dietCode}")
    public ResponseEntity<DietPostResponseDto> updateDietPost(
            @PathVariable int dietCode,
            @RequestBody DietPostRequestDto dto) {
        return ResponseEntity.ok(dietPostCommandService.updateDietPost(dietCode, dto));
    }

    /* 설명. 게시물 삭제(soft delete) */
    @DeleteMapping("/{dietCode}")
    public ResponseEntity<String> deleteDietPost(@PathVariable int dietCode) {
        dietPostCommandService.deleteDietPost(dietCode);
        return ResponseEntity.ok("게시물이 삭제되었습니다.");
    }

    /* 설명. 게시물 조회수 증가 */
    @PatchMapping("/{dietCode}/view")
    public ResponseEntity<String> increaseViewCount(@PathVariable int dietCode) {
        dietPostCommandService.increaseViewCount(dietCode);
        return ResponseEntity.ok("조회수 증가 완료");
    }

    /* 설명. 게시물 좋아요 증가 */
    @PatchMapping("/{dietCode}/like")
    public ResponseEntity<String> increaseLikeCount(@PathVariable int dietCode) {
        dietPostCommandService.increaseLikeCount(dietCode);
        return ResponseEntity.ok("좋아요 증가 완료");
    }

    /* 설명. 게시물 댓글 수 증가 */
    @PatchMapping("/{dietCode}/comment")
    public ResponseEntity<String> increaseCommentCount(@PathVariable int dietCode) {
        dietPostCommandService.increaseCommentCount(dietCode);
        return ResponseEntity.ok("댓글 수 증가 완료");
    }
}

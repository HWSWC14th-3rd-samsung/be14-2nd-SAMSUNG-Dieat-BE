package com.samsung.dieat.comment.query.application.controller;

import com.samsung.dieat.comment.query.application.dto.CommentResponseDTO;
import com.samsung.dieat.comment.query.application.service.CommentQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentQueryController {

    private final CommentQueryService commentQueryService;

    @GetMapping("/targetType/{targetType}/targetCode/{targetCode}")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByTarget(
            @PathVariable String targetType,
            @PathVariable int targetCode) {
        List<CommentResponseDTO> comments = commentQueryService.getCommentsByTarget(targetType, targetCode);
        return ResponseEntity.ok(comments);
    }
}

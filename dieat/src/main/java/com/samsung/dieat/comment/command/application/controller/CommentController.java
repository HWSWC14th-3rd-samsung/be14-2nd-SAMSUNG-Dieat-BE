package com.samsung.dieat.comment.command.application.controller;

import com.samsung.dieat.comment.command.application.dto.CommentRequestDTO;
import com.samsung.dieat.comment.command.application.dto.CommentUpdateDTO;
import com.samsung.dieat.comment.command.application.service.CommentService;
import com.samsung.dieat.comment.command.domain.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentRequestDTO request) {
        Comment comment = commentService.createComment(request);
        return ResponseEntity.ok(comment);
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody CommentUpdateDTO request) {
        Comment comment = commentService.updateComment(request);
        return ResponseEntity.ok(comment);
    }

    // 댓글 삭제 (Soft)
    @DeleteMapping("/{cmtCode}")
    public ResponseEntity<Void> deleteComment(@PathVariable int cmtCode) {
        commentService.deleteComment(cmtCode);
        return ResponseEntity.noContent().build();
    }
}

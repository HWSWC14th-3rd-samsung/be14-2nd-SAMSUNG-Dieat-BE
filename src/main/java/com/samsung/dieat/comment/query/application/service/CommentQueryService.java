package com.samsung.dieat.comment.query.application.service;

import com.samsung.dieat.comment.query.application.dto.CommentResponseDTO;
import com.samsung.dieat.comment.query.infrastructure.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentQueryService {

    private final CommentMapper commentMapper;

    public List<CommentResponseDTO> getCommentsByTarget(String targetType, int targetCode) {
        return commentMapper.findCommentsByTarget(targetType, targetCode);
    }
}

package com.samsung.dieat.comment.command.application.service;

import com.samsung.dieat.comment.command.application.dto.CommentRequestDTO;
import com.samsung.dieat.comment.command.application.dto.CommentUpdateDTO;
import com.samsung.dieat.comment.command.domain.entity.Comment;
import com.samsung.dieat.comment.command.infrastructure.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(CommentRequestDTO request) {
        Comment comment = Comment.builder()
                .cmtConts(request.getCmtConts())
                .cmtTargetType(request.getCmtTargetType())
                .cmtTargetCode(request.getCmtTargetCode())
                .userCode(request.getUserCode())
                .cmtCreatedDt(LocalDateTime.now())
                .cmtIsDeleted(false)
                .build();
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(CommentUpdateDTO request) {
        Optional<Comment> optionalComment = commentRepository.findById(request.getCmtCode());
        if(optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setCmtConts(request.getCmtConts());
            comment.setCmtUpdatedDt(LocalDateTime.now());
            return commentRepository.save(comment);
        }
        throw new RuntimeException("Comment not found with id: " + request.getCmtCode());
    }

    @Transactional
    public void deleteComment(int cmtCode) {
        Optional<Comment> optionalComment = commentRepository.findById(cmtCode);
        if(optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            // Soft delete: update deletion flag and update timestamp
            comment.setCmtIsDeleted(true);
            comment.setCmtUpdatedDt(LocalDateTime.now());
            commentRepository.save(comment);
        } else {
            throw new RuntimeException("Comment not found with id: " + cmtCode);
        }
    }
}

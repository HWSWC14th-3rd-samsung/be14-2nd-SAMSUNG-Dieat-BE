package com.samsung.dieat.comment.command.infrastructure;

import com.samsung.dieat.comment.command.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

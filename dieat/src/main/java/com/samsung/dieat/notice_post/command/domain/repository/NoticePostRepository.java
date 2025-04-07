package com.samsung.dieat.notice_post.command.domain.repository;

import com.samsung.dieat.notice_post.command.domain.aggregate.entity.NoticePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticePostRepository extends JpaRepository<NoticePost, Integer> {
}

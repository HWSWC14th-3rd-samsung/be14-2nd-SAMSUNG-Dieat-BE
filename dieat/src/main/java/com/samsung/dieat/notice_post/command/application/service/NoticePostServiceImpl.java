package com.samsung.dieat.notice_post.command.application.service;

import com.samsung.dieat.notice_post.command.application.dto.NoticePostRequestDTO;
import com.samsung.dieat.notice_post.command.domain.aggregate.entity.NoticePost;
import com.samsung.dieat.notice_post.command.domain.repository.NoticePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoticePostServiceImpl implements NoticePostService {

    private final NoticePostRepository noticePostRepository;

    @Autowired
    public NoticePostServiceImpl(NoticePostRepository noticePostRepository) {
        this.noticePostRepository = noticePostRepository;
    }

    @Override
    public void registerNotice(NoticePostRequestDTO dto) {
        NoticePost post = NoticePost.builder()
                .notiTitle(dto.getTitle())
                .notiConts(dto.getContent())
                .notiCreatedDt(LocalDateTime.now())
                .build();

        noticePostRepository.save(post);
    }
}

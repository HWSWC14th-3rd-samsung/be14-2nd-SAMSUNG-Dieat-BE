package com.samsung.dieat.notice_post.command.application.service;


import com.samsung.dieat.notice_post.command.application.dto.NoticePostRequestDTO;

public interface NoticePostService {
    void registerNotice(NoticePostRequestDTO dto);
}

package com.samsung.dieat.notice_post.command.application.service;


import com.samsung.dieat.notice_post.command.application.dto.NoticePostRequestDTO;
import com.samsung.dieat.notice_post.command.application.dto.NoticePostUpdateDTO;

public interface NoticePostService {
    void registerNotice(NoticePostRequestDTO dto);
    void updateNotice(int noticeCode, NoticePostUpdateDTO dto);
}


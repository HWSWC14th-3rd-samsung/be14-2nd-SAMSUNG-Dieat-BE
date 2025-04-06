package com.samsung.dieat.notice_post.query.service;

import com.samsung.dieat.notice_post.query.dao.NoticePostMapper;
import com.samsung.dieat.notice_post.query.dto.NoticePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticePostQueryService {

    private final NoticePostMapper noticePostMapper;

    @Autowired
    public NoticePostQueryService(NoticePostMapper noticePostMapper) {
        this.noticePostMapper = noticePostMapper;
    }

    public List<NoticePostVO> getAllNotices() {
        return noticePostMapper.selectAllNotices();
    }
}

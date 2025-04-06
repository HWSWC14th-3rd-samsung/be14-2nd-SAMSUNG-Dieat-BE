package com.samsung.dieat.notice_post.query.controller;

import com.samsung.dieat.notice_post.query.dto.NoticePostDetailVO;
import com.samsung.dieat.notice_post.query.dto.NoticePostVO;
import com.samsung.dieat.notice_post.query.service.NoticePostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticePostQueryController {

    private final NoticePostQueryService noticePostQueryService;

    @Autowired
    public NoticePostQueryController(NoticePostQueryService noticePostQueryService) {
        this.noticePostQueryService = noticePostQueryService;
    }

    @GetMapping
    public ResponseEntity<List<NoticePostVO>> getAllNotices() {
        List<NoticePostVO> list = noticePostQueryService.getAllNotices();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{noticeCode}")
    public ResponseEntity<NoticePostDetailVO> getNoticeByNoticeCode(@PathVariable("noticeCode") int noticeCode) {
        NoticePostDetailVO result=noticePostQueryService.getNoticeDetail(noticeCode);
        return ResponseEntity.ok(result);
    }
}

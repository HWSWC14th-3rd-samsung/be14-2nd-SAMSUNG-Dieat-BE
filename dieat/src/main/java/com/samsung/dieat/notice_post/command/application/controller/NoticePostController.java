package com.samsung.dieat.notice_post.command.application.controller;

import com.samsung.dieat.notice_post.command.application.dto.NoticePostRequestDTO;
import com.samsung.dieat.notice_post.command.application.service.NoticePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
public class NoticePostController {

    private final NoticePostService noticePostService;

    @Autowired
    public NoticePostController(NoticePostService noticePostService) {
        this.noticePostService = noticePostService;
    }

    @PostMapping
    public ResponseEntity<String> registerNotice(@RequestBody NoticePostRequestDTO dto) {
        noticePostService.registerNotice(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("공지사항 등록 완료");
    }
}

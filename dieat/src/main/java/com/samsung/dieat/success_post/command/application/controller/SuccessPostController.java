package com.samsung.dieat.success_post.command.application.controller;

import com.samsung.dieat.success_post.command.application.dto.SuccessPostCreateDto;
import com.samsung.dieat.success_post.command.application.dto.SuccessPostDTO;
import com.samsung.dieat.success_post.command.application.service.SuccessPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/success_post")
@Slf4j
public class SuccessPostController {

    private final SuccessPostService successPostService;

    @Autowired
    public SuccessPostController(SuccessPostService successPostService) {
        this.successPostService = successPostService;
    }

    /* 게시물 등록 */
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<SuccessPostDTO> createSuccessPost(@RequestBody SuccessPostCreateDto successPostCreateDto) {
        SuccessPostDTO createdPost = successPostService.createSuccessPost(successPostCreateDto);

        // 201 Created 상태 코드로 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PostMapping("/update/{succCode}")
    @Transactional
    public ResponseEntity<SuccessPostDTO> updateSuccessPost(@PathVariable int succCode,
                                        @RequestBody SuccessPostCreateDto successPostCreateDto) {
        SuccessPostDTO updatePost = successPostService.updateSuccessPost(succCode, successPostCreateDto);
        return ResponseEntity.ok(updatePost);
    }

    @PostMapping("/delete/{succCode}")
    @Transactional
    public ResponseEntity<SuccessPostDTO> deleteSuccessPost(@PathVariable int succCode) {
        successPostService.deleteSuccPost(succCode);
        return ResponseEntity.ok().build();
    }
}

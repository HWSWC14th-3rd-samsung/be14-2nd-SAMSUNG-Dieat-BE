package com.samsung.dieat.success_post.command.application.controller;

import com.samsung.dieat.success_post.command.application.dto.SuccessPostRegistDTO;
import com.samsung.dieat.success_post.command.application.dto.SuccessPostResponseDTO;
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
    public ResponseEntity<SuccessPostResponseDTO> createSuccessPost(@RequestBody SuccessPostRegistDTO successPostRegistDTO) {
        SuccessPostResponseDTO createdPost = successPostService.createSuccessPost(successPostRegistDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PostMapping("/update/{succCode}")
    @Transactional
    public ResponseEntity<SuccessPostResponseDTO> updateSuccessPost(@PathVariable int succCode,
                                                                    @RequestBody SuccessPostRegistDTO successPostRegistDTO) {
        SuccessPostResponseDTO updatePost = successPostService.updateSuccessPost(succCode, successPostRegistDTO);
        return ResponseEntity.ok(updatePost);
    }

    @PostMapping("/delete/{userCode}")
    @Transactional
    public ResponseEntity<SuccessPostResponseDTO> deleteSuccessPost(@PathVariable int userCode) {
        successPostService.deleteSuccPost(userCode);
        return ResponseEntity.ok().build();
    }
}

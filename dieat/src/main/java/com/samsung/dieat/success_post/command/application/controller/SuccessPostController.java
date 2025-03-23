package com.samsung.dieat.success_post.command.application.controller;

import com.samsung.dieat.success_post.command.application.dto.SuccessPostDTO;
import com.samsung.dieat.success_post.command.application.service.SuccessPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SuccessPostController {
    private final SuccessPostService successPostService;

    @Autowired
    public SuccessPostController(SuccessPostService successPostService) {
        this.successPostService = successPostService;
    }

    @PostMapping("/registSuccessPost")
    public ResponseEntity<SuccessPostDTO> registSuccessPost(@RequestParam int userCode,
                                                            @RequestParam String succTitle,
                                                            @RequestParam String succConts) {
        return ResponseEntity.ok(successPostService.registSuccessPost(userCode, succTitle, succConts));
    }

    @PostMapping("/modifySuccessPost")
    public ResponseEntity<SuccessPostDTO> modifySuccessPost(@RequestParam int succCode,
                                                            @RequestParam String succTitle,
                                                            @RequestParam String succConts) {
        return ResponseEntity.ok(successPostService.modifySuccessPost(succCode, succTitle, succConts));
    }
}

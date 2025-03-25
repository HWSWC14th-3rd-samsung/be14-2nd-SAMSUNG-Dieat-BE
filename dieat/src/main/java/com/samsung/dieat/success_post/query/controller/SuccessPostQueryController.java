package com.samsung.dieat.success_post.query.controller;

import com.samsung.dieat.success_post.query.dto.SuccPostQueryDTO;
import com.samsung.dieat.success_post.query.service.SuccessPostQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/success_post")
@RequiredArgsConstructor
public class SuccessPostQueryController {

    private final SuccessPostQueryService successPostQueryService;

    @GetMapping("/user/{userCode}")
    public List<SuccPostQueryDTO> successPost1(@PathVariable int userCode) {
        return successPostQueryService.getSuccPostForUserCode(userCode);
    }

    @GetMapping("/title/{succTitle}")
    public List<SuccPostQueryDTO> successPost2(@PathVariable String succTitle) {
        return successPostQueryService.getSuccPostForTitle(succTitle);
    }

}

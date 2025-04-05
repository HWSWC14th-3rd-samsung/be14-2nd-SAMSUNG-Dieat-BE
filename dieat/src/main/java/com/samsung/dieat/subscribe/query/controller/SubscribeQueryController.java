package com.samsung.dieat.subscribe.query.controller;

import com.samsung.dieat.security.CustomUserDetails;
import com.samsung.dieat.security.JwtUtil;
import com.samsung.dieat.subscribe.query.dto.SubscribedPostVO;
import com.samsung.dieat.subscribe.query.dto.SubscribedUserVO;
import com.samsung.dieat.subscribe.query.service.SubscribePostQueryService;
import com.samsung.dieat.subscribe.query.service.SubscribeQueryService;
import com.samsung.dieat.subscribe.query.service.SubscribeUserPostQueryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribes")
public class SubscribeQueryController {

    private final SubscribeQueryService subscribeQueryService;
    private final SubscribePostQueryService subscribePostQueryService;
    private final SubscribeUserPostQueryService subscribeUserPostQueryService;

    private final JwtUtil jwtUtil;

    @Autowired
    public SubscribeQueryController(SubscribeQueryService subscribeQueryService,
                                    JwtUtil jwtUtil,
                                    SubscribePostQueryService subscribePostQueryService,
                                    SubscribeUserPostQueryService subscribeUserPostQueryService) {
        this.subscribeQueryService = subscribeQueryService;
        this.subscribePostQueryService = subscribePostQueryService;
        this.subscribeUserPostQueryService = subscribeUserPostQueryService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getSubscribedUsers(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);

        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails =
                    (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int userCode = userDetails.getUserCode();

            List<SubscribedUserVO> list = subscribeQueryService.getSubscribedUsers(userCode);
            return ResponseEntity.ok(list);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }
    @GetMapping("/posts")
    public ResponseEntity<?> getSubscribedPosts(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);

        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails =
                    (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int userCode = userDetails.getUserCode();

            List<SubscribedPostVO> posts = subscribePostQueryService.getSubscribedPosts(userCode);
            return ResponseEntity.ok(posts);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }

    @GetMapping("/user")
    public ResponseEntity<List<SubscribedPostVO>> getPostsByUser(@RequestParam("userCode") int userCode) {
        List<SubscribedPostVO> posts = subscribeUserPostQueryService.getPostsByUserCode(userCode);
        return ResponseEntity.ok(posts);
    }
}

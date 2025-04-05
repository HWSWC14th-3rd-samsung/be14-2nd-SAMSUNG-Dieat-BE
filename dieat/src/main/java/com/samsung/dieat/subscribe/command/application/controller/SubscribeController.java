package com.samsung.dieat.subscribe.command.application.controller;

import com.samsung.dieat.security.CustomUserDetails;
import com.samsung.dieat.security.JwtUtil;
import com.samsung.dieat.subscribe.command.application.service.SubscribeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribes")
public class SubscribeController {

    private final SubscribeService subscribeService;
    private final JwtUtil jwtUtil;

    @Autowired
    public SubscribeController(SubscribeService subscribeService, JwtUtil jwtUtil) {
        this.subscribeService = subscribeService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> subscribe(@RequestParam("targetUserCode") Integer targetUserCode,
                                       HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);

        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails =
                    (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Integer userCode = userDetails.getUserCode();

            subscribeService.subscribe(userCode, targetUserCode);
            return ResponseEntity.status(HttpStatus.CREATED).body("구독 완료");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }
}

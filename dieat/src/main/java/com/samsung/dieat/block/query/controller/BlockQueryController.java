package com.samsung.dieat.block.query.controller;

import com.samsung.dieat.block.query.dto.BlockedUserVO;
import com.samsung.dieat.block.query.service.BlockQueryService;
import com.samsung.dieat.security.CustomUserDetails;
import com.samsung.dieat.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocks")
public class BlockQueryController {

    private final BlockQueryService blockQueryService;
    private final JwtUtil jwtUtil;

    @Autowired
    public BlockQueryController(BlockQueryService blockQueryService, JwtUtil jwtUtil) {
        this.blockQueryService = blockQueryService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyBlockedUsers(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);

        if (jwtUtil.validateToken(token)) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int authenticatedUserCode = userDetails.getUserCode();

            List<BlockedUserVO> result = blockQueryService.getBlockedUsers(authenticatedUserCode);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }
}

package com.samsung.dieat.block.command.application.controller;

import com.samsung.dieat.block.command.application.dto.BlockRequestDTO;
import com.samsung.dieat.block.command.application.service.BlockService;
import com.samsung.dieat.security.CustomUserDetails;
import com.samsung.dieat.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    private final BlockService blockService;
    private final JwtUtil jwtUtil;

    @Autowired
    public BlockController(BlockService blockService, JwtUtil jwtUtil) {
        this.blockService = blockService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> registerBlock(@RequestBody BlockRequestDTO dto, HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        if (jwtUtil.validateToken(token)) {
            System.out.println("토큰 까기 성공");
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int authenticatedUserCode = userDetails.getUserCode();

            blockService.registerBlock(authenticatedUserCode, dto.getTargetUserCode());
            return ResponseEntity.status(HttpStatus.CREATED).body("차단 완료");
        }else{
            System.out.println("토큰 까기 실패");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 인증 실패");
    }
}


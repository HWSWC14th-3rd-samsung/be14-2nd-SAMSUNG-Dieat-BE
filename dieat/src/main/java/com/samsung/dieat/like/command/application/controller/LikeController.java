package com.samsung.dieat.like.command.application.controller;

import com.samsung.dieat.like.command.application.service.LikeService;
//import com.samsung.dieat.like.command.domain.dto.LikeRequestDTO;
//import com.samsung.dieat.like.command.domain.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

//    private final LikeService likeService;
//
//    @PostMapping
//    public ResponseEntity<Like> addLike(@RequestBody LikeRequestDTO request) {
//        Like like = likeService.addLike(
//                request.getLikesTargetCode(),
//                request.getTargetType(),
//                request.getUserCode()
//        );
//        return ResponseEntity.status(HttpStatus.CREATED).body(like);
//    }
//
//    @DeleteMapping
//    public ResponseEntity<Void> removeLike(@RequestBody LikeRequestDTO request) {
//        likeService.removeLike(
//                request.getLikesTargetCode(),
//                request.getTargetType(),
//                request.getUserCode()
//        );
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}

package com.samsung.dieat.like.command.application.controller;

import com.samsung.dieat.like.command.application.service.LikeService;
<<<<<<< HEAD
import com.samsung.dieat.like.command.domain.dto.LikeRequestDTO;
import com.samsung.dieat.like.command.domain.entity.Like;
=======
//import com.samsung.dieat.like.command.domain.dto.LikeRequestDTO;
//import com.samsung.dieat.like.command.domain.entity.Like;
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

<<<<<<< HEAD
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> addLike(@RequestBody LikeRequestDTO request) {
        Like like = likeService.addLike(
                request.getLikesTargetCode(),
                request.getTargetType(),
                request.getUserCode()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(like);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeLike(@RequestBody LikeRequestDTO request) {
        likeService.removeLike(
                request.getLikesTargetCode(),
                request.getTargetType(),
                request.getUserCode()
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
=======
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
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
}

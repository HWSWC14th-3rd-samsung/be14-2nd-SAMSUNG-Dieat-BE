package com.samsung.dieat.like.command.application.service;

import com.samsung.dieat.like.command.domain.entity.Like;
import com.samsung.dieat.like.command.domain.entity.Like.LikeId;
import com.samsung.dieat.like.command.domain.entity.LikesTargetType;
import com.samsung.dieat.like.command.domain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    @Transactional
    public Like addLike(int likesTargetCode, LikesTargetType targetType, int userCode) {
        LikeId id = new LikeId(likesTargetCode, targetType, userCode);
        // 이미 존재하면 그대로 반환, 없으면 새로 저장
        return likeRepository.findById(id)
                .orElseGet(() -> {
                    Like newLike = Like.builder()
                            .id(id)
                            .build();
                    return likeRepository.save(newLike);
                });
    }


    @Transactional
    public void removeLike(int likesTargetCode, LikesTargetType targetType, int userCode) {
        LikeId id = new LikeId(likesTargetCode, targetType, userCode);
        likeRepository.deleteById(id);
    }
}

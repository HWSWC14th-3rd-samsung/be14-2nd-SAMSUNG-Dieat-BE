package com.samsung.dieat.diet_post.command.application.service;

import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import com.samsung.dieat.diet_post.command.domain.repository.DietPostRepository;
import com.samsung.dieat.diet_post.command.application.dto.DietPostCreateDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DietPostCommandService {

    private final DietPostRepository dietPostRepository;

    /* 설명. 식단 게시물 등록 */
    @Transactional
    public DietPost createDietPost(DietPostCreateDto dto) {
        DietPost dietPost = DietPost.builder()
                .dietUploadDt(LocalDateTime.now())
                .dietTitle(dto.getDietTitle())
                .dietConts(dto.getDietConts())
                .dietViewCnt(0)
                .dietLikeCnt(0)
                .dietCmtCnt(0)
                .dietCalories(dto.getDietCalories())
                .dietCarbs(dto.getDietCarbs())
                .dietProtein(dto.getDietProtein())
                .dietFat(dto.getDietFat())
                .dietSugar(dto.getDietSugar())
                .dietIsDeleted(false)
                .userCode(dto.getUserCode())
                .build();

        return dietPostRepository.save(dietPost);
    }

    /* 설명. 식단 게시물 수정 */
    @Transactional
    public DietPost updateDietPost(Long dietCode, DietPostUpdateDto dto) {
        DietPost dietPost = dietPostRepository.findById(dietCode)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        dietPost.setDietTitle(dto.getDietTitle());
        dietPost.setDietConts(dto.getDietConts());
        dietPost.setDietCalories(dto.getDietCalories());
        dietPost.setDietCarbs(dto.getDietCarbs());
        dietPost.setDietProtein(dto.getDietProtein());
        dietPost.setDietFat(dto.getDietFat());
        dietPost.setDietSugar(dto.getDietSugar());

        return dietPostRepository.save(dietPost);
    }

    /* 설명. 식단 게시물 삭제 (소프트 삭제) */
    @Transactional
    public void deleteDietPost(Long dietCode) {
        DietPost dietPost = dietPostRepository.findById(dietCode)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        dietPost.setDietIsDeleted(true);
        dietPostRepository.save(dietPost);
    }
}

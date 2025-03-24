package com.samsung.dieat.diet_post.command.application.service;

import com.samsung.dieat.diet_post.command.application.dto.DietPostCreateDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostRequestDto;
import com.samsung.dieat.diet_post.command.application.dto.DietPostResponseDto;
import com.samsung.dieat.diet_post.command.application.mapper.DietPostMapper;
import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import com.samsung.dieat.diet_post.command.domain.repository.DietPostRepository;
import com.samsung.dieat.diet_post.command.domain.service.DietPostDomainService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DietPostCommandService {

    private final DietPostRepository dietPostRepository;
    private final DietPostDomainService dietPostDomainService;
    private final DietPostMapper dietPostMapper;

    /* 설명. 게시물 등록 */
    @Transactional
    public DietPostResponseDto createDietPost(DietPostCreateDto dto) {
        DietPost dietPost = DietPost.builder()
                .dietUploadDt(LocalDateTime.now())
                .dietTitle(dto.getDietTitle())
                .dietConts(dto.getDietConts())
                .dietCalories(dto.getDietCalories())
                .dietCarbs(dto.getDietCarbs())
                .dietSugar(dto.getDietSugar())
                .dietProtein(dto.getDietProtein())
                .dietFat(dto.getDietFat())
                .dietViewCnt(0)
                .dietLikeCnt(0)
                .dietCmtCnt(0)
                .dietIsDeleted(false)
                .userCode(dto.getUserCode())
                .build();

        return dietPostMapper.toResponseDto(dietPostRepository.save(dietPost));
    }

    /* 설명. 게시물 수정 */
    @Transactional
    public DietPostResponseDto updateDietPost(int dietCode, DietPostRequestDto dto) {
        DietPost dietPost = dietPostRepository.findById(dietCode)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시물이 존재하지 않습니다."));

        dietPost.setDietTitle(dto.getDietTitle());
        dietPost.setDietConts(dto.getDietConts());
        dietPost.setDietCalories(dto.getDietCalories());
        dietPost.setDietCarbs(dto.getDietCarbs());
        dietPost.setDietSugar(dto.getDietSugar());
        dietPost.setDietProtein(dto.getDietProtein());
        dietPost.setDietFat(dto.getDietFat());

        return dietPostMapper.toResponseDto(dietPostRepository.save(dietPost));
    }

    /* 설명. 게시물 삭제(soft delete) */
    @Transactional
    public void deleteDietPost(int dietCode) {
        DietPost post = dietPostRepository.findById(dietCode)
                .orElseThrow(() -> new EntityNotFoundException("게시물이 존재하지 않습니다."));
        dietPostDomainService.softDeleteDietPost(post);
        dietPostRepository.save(post);
    }

    /* 설명. 조회수 증가 */
    @Transactional
    public void increaseViewCount(int dietCode) {
        DietPost post = getById(dietCode);
        dietPostDomainService.increaseViewCount(post);
        dietPostRepository.save(post);
    }

    /* 설명. 좋아요 증가 */
    @Transactional
    public void increaseLikeCount(int dietCode) {
        DietPost post = getById(dietCode);
        dietPostDomainService.increaseLikeCount(post);
        dietPostRepository.save(post);
    }

    /* 설명. 댓글 수 증가 */
    @Transactional
    public void increaseCommentCount(int dietCode) {
        DietPost post = getById(dietCode);
        dietPostDomainService.increaseCommentCount(post);
        dietPostRepository.save(post);
    }

    /* 설명. 내부 공통 조회 */
    private DietPost getById(int dietCode) {
        return dietPostRepository.findById(dietCode)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시물이 존재하지 않습니다."));
    }
}

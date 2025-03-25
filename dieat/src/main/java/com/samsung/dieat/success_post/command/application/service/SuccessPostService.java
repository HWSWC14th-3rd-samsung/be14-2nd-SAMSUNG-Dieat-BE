package com.samsung.dieat.success_post.command.application.service;

import com.samsung.dieat.point.command.application.event.PostCreatedEvent;
import com.samsung.dieat.point.command.application.service.PointService;
import com.samsung.dieat.point.command.domain.enums.PType;
import com.samsung.dieat.success_post.command.application.dto.SuccessPostRegistDTO;
import com.samsung.dieat.success_post.command.application.dto.SuccessPostResponseDTO;
import com.samsung.dieat.success_post.command.domain.aggregate.entity.SuccessPostEntity;
import com.samsung.dieat.success_post.command.domain.repository.SuccessPostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SuccessPostService {

    private final SuccessPostRepository successPostRepository;
    private final ModelMapper modelMapper;
//    private final DomainEventPublisher domainEventPublisher;
    private final ApplicationEventPublisher eventPublisher;
    private final PointService pointService;

    @Autowired
    public SuccessPostService(SuccessPostRepository successPostRepository, ModelMapper modelMapper, ApplicationEventPublisher eventPublisher, PointService pointService) {
        this.successPostRepository = successPostRepository;
        this.modelMapper = modelMapper;
        this.eventPublisher = eventPublisher;
        this.pointService = pointService;
    }

    /* 성공 게시물 등록 */
    @Transactional
    public SuccessPostResponseDTO createSuccessPost(SuccessPostRegistDTO dto) {
        // SuccessPostEntity 객체 생성
        SuccessPostEntity successPost = SuccessPostEntity.builder()
                .succCreatedDt(LocalDateTime.now())  // 생성 일자
                .succTitle(dto.getSuccTitle())      // 게시물 제목
                .succConts(dto.getSuccConts())      // 게시물 내용
                .succViewCnt(0)                     // 조회수 초기화
                .succLikeCnt(0)                     // 좋아요 초기화
                .succCmtCnt(0)                      // 댓글 수 초기화
                .succIsdeleted(false)               // 삭제 여부 초기화
                .succTerm(dto.getSuccTerm())        // 성공 기간
                .userCode(dto.getUserCode())        // 사용자 정보 (UserEntity)
                .build();

        // 게시물 저장
        SuccessPostEntity savedSuccessPost = successPostRepository.save(successPost);

//        DomainEventPublisher.publish(domainEventPublisher);
        eventPublisher.publishEvent(new PostCreatedEvent(dto.getUserCode(), 10, PType.SUCCESS));

//        pointService.addPoints(dto.getUserCode(), 10, PType.SUCCESS);

        // DTO 변환 후 반환
        return modelMapper.map(savedSuccessPost, SuccessPostResponseDTO.class);
    }

    /* 설명. 게시물 수정 */
    @Transactional
    public SuccessPostResponseDTO updateSuccessPost(int succCode, SuccessPostRegistDTO dto) {
        SuccessPostEntity successPost = successPostRepository.findById(succCode)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시물이 존재하지 않습니다."));

        successPost.setSuccTitle(dto.getSuccTitle());
        successPost.setSuccConts(dto.getSuccConts());
        successPost.setSuccTerm(dto.getSuccTerm());

        return modelMapper.map(successPostRepository.save(successPost), SuccessPostResponseDTO.class);
//        return dietPostMapper.toResponseDto(successPostRepository.save(successPost));
    }

    @Transactional
    public void deleteSuccPost(int userCode) {
        SuccessPostEntity successPost = successPostRepository.findById(userCode)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시물이 존재하지 않습니다."));
        successPost.setSuccIsdeleted(true);
        successPostRepository.save(successPost);
    }
}

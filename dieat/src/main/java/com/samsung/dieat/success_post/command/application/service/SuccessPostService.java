package com.samsung.dieat.success_post.command.application.service;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserInfoEntity;
import com.samsung.dieat.member.command.domain.repository.UserInfoRepository;
import com.samsung.dieat.point.command.application.service.PointService;
import com.samsung.dieat.point.command.domain.enums.PType;
import com.samsung.dieat.success_post.command.application.dto.SuccessPostDTO;
import com.samsung.dieat.success_post.command.domain.aggregate.entity.SuccessPostEntity;
import com.samsung.dieat.success_post.command.domain.repository.SuccessPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.samsung.dieat.point.command.domain.enums.PType.SUCCESS;

@Service
@RequiredArgsConstructor
@Transactional
public class SuccessPostService {

    private final SuccessPostRepository successPostRepository;
    private final UserInfoRepository userInfoRepository;
    private final PointService dailyPointService;
    private final ModelMapper modelMapper;


    public SuccessPostDTO registSuccessPost(int userCode, String succTitle, String succConts, PType pType) {
        UserInfoEntity userInfo = userInfoRepository.findById(userCode)
                .orElseThrow(IllegalAccessError::new);

        SuccessPostEntity successPost = new SuccessPostEntity();
        successPost.setSuccTitle(succTitle);
        successPost.setSuccConts(succConts);
        successPost.setSuccCreatedDt(LocalDateTime.now());
        successPostRepository.save(successPost);

        dailyPointService.addPoints(userInfo.getUserCode(), 10, SUCCESS);

        return modelMapper.map(successPost, SuccessPostDTO.class);
    }

    public SuccessPostDTO modifySuccessPost(int succCode, String succTitle, String succConts) {
        SuccessPostEntity succPosts = successPostRepository.findById(succCode)
                .orElseThrow(IllegalAccessError::new);

        succPosts.setSuccTitle(succTitle);
        succPosts.setSuccConts(succConts);
        successPostRepository.save(succPosts);

        return modelMapper.map(succPosts, SuccessPostDTO.class);
    }

    public void deleteSuccessPost(int succCode) {
        SuccessPostEntity succPosts = successPostRepository.findById(succCode)
                .orElseThrow(IllegalAccessError::new);

        successPostRepository.delete(succPosts);
    }

}


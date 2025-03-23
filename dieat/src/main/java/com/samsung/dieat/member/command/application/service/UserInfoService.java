package com.samsung.dieat.member.command.application.service;

import com.samsung.dieat.member.command.application.dto.UserInfoDTO;
import com.samsung.dieat.member.command.domain.aggregate.entity.UserInfoEntity;
import com.samsung.dieat.member.command.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final ModelMapper modelMapper;

    public UserInfoDTO getUserInfoById(int userCode) {
        UserInfoEntity userInfo = userInfoRepository.findById(userCode)
                .orElseThrow(IllegalAccessError::new);

        return modelMapper.map(userInfo, UserInfoDTO.class);
    }
}

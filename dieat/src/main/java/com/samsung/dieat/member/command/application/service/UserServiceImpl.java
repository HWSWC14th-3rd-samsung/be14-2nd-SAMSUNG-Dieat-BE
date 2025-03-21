package com.samsung.dieat.member.command.application.service;

import com.samsung.dieat.member.command.application.dto.UserDTO;
import com.samsung.dieat.member.command.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registUser(UserDTO userDTO) {
        userDTO.setUserEnrollDt(new java.util.Date());

        modelMapper.
    }
}

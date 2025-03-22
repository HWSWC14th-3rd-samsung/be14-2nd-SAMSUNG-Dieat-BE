package com.samsung.dieat.member.command.application.service;

import com.samsung.dieat.member.command.application.dto.UserDTO;
import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import com.samsung.dieat.member.command.domain.repository.UserRepository;
import org.bouncycastle.crypto.generators.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void registUser(UserDTO userDTO) {
        userDTO.setUserEnrollDt(new java.util.Date());

        UserEntity registUser = modelMapper.map(userDTO, UserEntity.class);
        registUser.setEncryptedPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));

        userRepository.save(registUser);
    }
}

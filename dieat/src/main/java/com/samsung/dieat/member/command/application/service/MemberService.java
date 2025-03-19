package com.samsung.dieat.member.command.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


}

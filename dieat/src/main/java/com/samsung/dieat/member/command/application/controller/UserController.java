package com.samsung.dieat.member.command.application.controller;

import com.samsung.dieat.member.command.application.dto.UserDTO;
import com.samsung.dieat.member.command.application.service.UserService;
import com.samsung.dieat.member.command.domain.aggregate.vo.RequestRegistUserVO;
import com.samsung.dieat.member.command.domain.aggregate.vo.ResponseRegistUserVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private Environment env;
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(Environment env, UserService userService, ModelMapper modelMapper) {
        this.env = env;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/health")
    public String status(){
        return "살 빼!!!!" + env.getProperty("local.server.port");
    }

    @PostMapping("users")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);



        userService.registUser(userDTO);
        ResponseRegistUserVO successRegistUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(successRegistUser);

    }
}

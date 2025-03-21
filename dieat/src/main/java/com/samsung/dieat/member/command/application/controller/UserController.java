package com.samsung.dieat.member.command.application.controller;

import com.samsung.dieat.member.command.domain.aggregate.vo.RequestRegistUserVO;
import com.samsung.dieat.member.command.domain.aggregate.vo.ResponseRegistUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private Environment env;

    @Autowired
    public UserController(Environment env) {
        this.env = env;
    }


    @GetMapping("/health")
    public String status(){
        return "I'm Working in User Service" + env.getProperty("local.server.port");
    }

    @PostMapping("users")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {

    }
}

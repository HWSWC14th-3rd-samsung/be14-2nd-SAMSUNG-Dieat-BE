package com.samsung.dieat.point.command.application.controller;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PointController {

    private Environment env;
    private ModelMapper modelMapper;
}

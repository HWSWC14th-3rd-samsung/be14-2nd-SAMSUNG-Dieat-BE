package com.samsung.dieat.point.command.application.controller;


import com.samsung.dieat.point.command.application.service.DailyPointService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DailyPointController {

    private Environment env;
    private ModelMapper modelMapper;
    private DailyPointService dailyPointService;

    @Autowired
    public DailyPointController(Environment env, ModelMapper modelMapper, DailyPointService dailyPointService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.dailyPointService = dailyPointService;
    }
}

package com.samsung.dieat.point.command.application.controller;


import com.samsung.dieat.point.command.application.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DailyPointController {
    private final PointService dailyPointService;
}

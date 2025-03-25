package com.samsung.dieat.point.query.controller;

import com.samsung.dieat.point.query.dto.PointQueryDTO;
import com.samsung.dieat.point.query.service.PointQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointQueryController {
    private final PointQueryService pointQueryService;

    public PointQueryController(PointQueryService pointQueryService) {
        this.pointQueryService = pointQueryService;
    }

    @GetMapping("/total_point/{userCode}")
    public List<PointQueryDTO> totalPoint(@PathVariable int userCode) {
        return pointQueryService.getTotalPoint(userCode);
    }
}

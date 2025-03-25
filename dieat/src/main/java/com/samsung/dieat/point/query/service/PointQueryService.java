package com.samsung.dieat.point.query.service;

import com.samsung.dieat.point.query.dao.PointMapper;
import com.samsung.dieat.point.query.dto.PointQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointQueryService {

    private final PointMapper pointMapper;

    @Autowired
    public PointQueryService(PointMapper pointMapper) {
        this.pointMapper = pointMapper;
    }

    public List<PointQueryDTO> getTotalPoint(int userCode) {
        return pointMapper.getTotalPoint(userCode);
    }
}

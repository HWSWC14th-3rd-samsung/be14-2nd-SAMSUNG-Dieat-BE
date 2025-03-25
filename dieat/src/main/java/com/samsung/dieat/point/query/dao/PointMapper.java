package com.samsung.dieat.point.query.dao;

import com.samsung.dieat.point.query.dto.PointQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointMapper {
    List<PointQueryDTO> getTotalPoint(@Param("userCode") int userCode);
}

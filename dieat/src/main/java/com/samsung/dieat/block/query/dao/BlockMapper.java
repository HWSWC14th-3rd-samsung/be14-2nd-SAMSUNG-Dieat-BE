package com.samsung.dieat.block.query.dao;

import com.samsung.dieat.block.query.dto.BlockedUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlockMapper {
    List<BlockedUserVO> selectBlockedUsersByUserCode(@Param("userCode") int userCode);
}

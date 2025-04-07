package com.samsung.dieat.subscribe.query.dao;

import com.samsung.dieat.subscribe.query.dto.SubscribedUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubscribeMapper {
    List<SubscribedUserVO> selectSubscribedUsersByUserCode(@Param("userCode") int userCode);
}

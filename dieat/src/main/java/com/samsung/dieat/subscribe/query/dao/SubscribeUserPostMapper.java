package com.samsung.dieat.subscribe.query.dao;

import com.samsung.dieat.subscribe.query.dto.SubscribedPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubscribeUserPostMapper {
    List<SubscribedPostVO> selectPostsByUserCode(@Param("userCode") int userCode);
}

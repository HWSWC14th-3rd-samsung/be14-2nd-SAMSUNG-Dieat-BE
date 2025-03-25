package com.samsung.dieat.success_post.query.dao;

import com.samsung.dieat.success_post.query.dto.SuccPostQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface SuccPostMapper {
    List<SuccPostQueryDTO> getSuccPostForTitle(@Param("succTitle") String succTitle);

    List<SuccPostQueryDTO> getSuccPostForUserCode(@Param("userCode") int userCode);
}

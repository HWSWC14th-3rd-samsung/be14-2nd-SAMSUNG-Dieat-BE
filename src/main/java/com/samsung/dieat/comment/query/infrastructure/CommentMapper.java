package com.samsung.dieat.comment.query.infrastructure;

import com.samsung.dieat.comment.query.application.dto.CommentResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentResponseDTO> findCommentsByTarget(@Param("targetType") String targetType,
                                                  @Param("targetCode") int targetCode);
}

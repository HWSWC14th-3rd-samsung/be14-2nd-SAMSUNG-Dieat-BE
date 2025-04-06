package com.samsung.dieat.notice_post.query.dao;

import com.samsung.dieat.notice_post.query.dto.NoticePostDetailVO;
import com.samsung.dieat.notice_post.query.dto.NoticePostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticePostMapper {
    List<NoticePostVO> selectAllNotices();
    NoticePostDetailVO selectNoticePostByCode(int notiCode);
}

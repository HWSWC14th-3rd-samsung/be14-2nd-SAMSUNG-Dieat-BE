package com.samsung.dieat.subscribe.query.service;

import com.samsung.dieat.subscribe.query.dao.SubscribeUserPostMapper;
import com.samsung.dieat.subscribe.query.dto.SubscribedPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeUserPostQueryService {

    private final SubscribeUserPostMapper userPostMapper;

    @Autowired
    public SubscribeUserPostQueryService(SubscribeUserPostMapper userPostMapper) {
        this.userPostMapper = userPostMapper;
    }

    public List<SubscribedPostVO> getPostsByUserCode(int userCode) {
        return userPostMapper.selectPostsByUserCode(userCode);
    }
}

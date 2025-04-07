package com.samsung.dieat.subscribe.query.service;

import com.samsung.dieat.subscribe.query.dao.SubscribePostMapper;
import com.samsung.dieat.subscribe.query.dto.SubscribedPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribePostQueryService {

    private final SubscribePostMapper postMapper;

    @Autowired
    public SubscribePostQueryService(SubscribePostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<SubscribedPostVO> getSubscribedPosts(int userCode) {
        return postMapper.selectSubscribedPosts(userCode);
    }
}

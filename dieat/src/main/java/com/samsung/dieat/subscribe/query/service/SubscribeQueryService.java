package com.samsung.dieat.subscribe.query.service;

import com.samsung.dieat.subscribe.query.dao.SubscribeMapper;
import com.samsung.dieat.subscribe.query.dto.SubscribedUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeQueryService {

    private final SubscribeMapper subscribeMapper;

    @Autowired
    public SubscribeQueryService(SubscribeMapper subscribeMapper) {
        this.subscribeMapper = subscribeMapper;
    }

    public List<SubscribedUserVO> getSubscribedUsers(int userCode) {
        return subscribeMapper.selectSubscribedUsersByUserCode(userCode);
    }
}

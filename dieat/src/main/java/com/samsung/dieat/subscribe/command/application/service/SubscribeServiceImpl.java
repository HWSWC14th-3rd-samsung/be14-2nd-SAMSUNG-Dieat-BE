package com.samsung.dieat.subscribe.command.application.service;

import com.samsung.dieat.subscribe.command.domain.aggregate.entity.Subscribe;
import com.samsung.dieat.subscribe.command.domain.aggregate.entity.SubscribeId;
import com.samsung.dieat.subscribe.command.domain.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    @Override
    public void subscribe(Integer requesterUserCode, Integer targetUserCode) {
        if (requesterUserCode.equals(targetUserCode)) {
            throw new IllegalArgumentException("자기 자신을 구독할 수 없습니다.");
        }

        SubscribeId id = new SubscribeId(requesterUserCode, targetUserCode);
        if (!subscribeRepository.existsById(id)) {
            subscribeRepository.save(new Subscribe(requesterUserCode, targetUserCode));
        }
    }

    @Override
    public void unsubscribe(Integer requesterUserCode, Integer targetUserCode) {
        SubscribeId id = new SubscribeId(requesterUserCode, targetUserCode);
        if (subscribeRepository.existsById(id)) {
            subscribeRepository.deleteById(id);
        }
    }
}

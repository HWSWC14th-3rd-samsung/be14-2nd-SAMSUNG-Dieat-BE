package com.samsung.dieat.subscribe.command.application.service;

public interface SubscribeService {
    void subscribe(Integer requesterUserCode, Integer targetUserCode);
    void unsubscribe(Integer requesterUserCode, Integer targetUserCode);
}

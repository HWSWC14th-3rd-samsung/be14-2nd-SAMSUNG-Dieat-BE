package com.samsung.dieat.point.command.application.event;

import com.samsung.dieat.point.command.application.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PointEventListener {
    private final PointService pointService;

    @Autowired
    public PointEventListener(PointService pointService) {
        this.pointService = pointService;
    }

    @Async
    @EventListener
    public void handleSuccessPostCreated(PostCreatedEvent event) {
        // ✅ 포인트 적립 실행
        pointService.addPoints(event.getUserCode(), event.getPoint(), event.getPType());
    }
}

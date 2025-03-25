package com.samsung.dieat.point.command.application.event;

import com.samsung.dieat.point.command.domain.enums.PType;
import lombok.Getter;

@Getter
public class PostCreatedEvent {
    private final int userCode;
    private final int point;
    private final PType pType;

    public PostCreatedEvent(int userCode, int point, PType pType) {
        this.userCode = userCode;
        this.point = point;
        this.pType = pType;
    }
}

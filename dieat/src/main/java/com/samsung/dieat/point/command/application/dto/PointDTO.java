package com.samsung.dieat.point.command.application.dto;

import com.samsung.dieat.point.command.domain.enums.PType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PointDTO {
    private int pointCode;
    private Long pointUserCode;
    private int pointAmt;
    private LocalDateTime pointRcvDt;
    private PType pointRcvType;
    private int pointRcvCode;
}

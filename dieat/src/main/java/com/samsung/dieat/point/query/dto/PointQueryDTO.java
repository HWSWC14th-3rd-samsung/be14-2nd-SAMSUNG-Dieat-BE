package com.samsung.dieat.point.query.dto;

import com.samsung.dieat.point.command.domain.enums.PType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PointQueryDTO {
    private int pointCode;
    private int pointUserCode;
    private int pointAmt;
    private LocalDateTime pointRcvDt;
    private PType pointRcvType;
    private int pointRcvCode;
}

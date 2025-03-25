package com.samsung.dieat.point.command.application.dto;

import com.samsung.dieat.point.command.domain.enums.PType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PointDTO {
    private int pointCode;
    private Long pointUserCode;
    private int pointAmt;
    private LocalDateTime pointRcvDt;
    private PType pointRcvType;
    private int pointRcvCode;
}

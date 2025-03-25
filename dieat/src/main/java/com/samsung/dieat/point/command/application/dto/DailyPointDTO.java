package com.samsung.dieat.point.command.application.dto;

import com.samsung.dieat.point.command.domain.enums.PType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DailyPointDTO {
    private int dPointCode;
    private int dPointUserCode;
    private int dPointAmt;
    private LocalDateTime dPointRcvDt;
    private PType dPointRcvType;
    private int dPointRcvCode;
}

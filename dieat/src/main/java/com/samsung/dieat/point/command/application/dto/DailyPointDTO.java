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
public class DailyPointDTO {
    private int dPointCode;
    private Long dPointUserCode;
    private int dPointRcvAmt;
    private LocalDateTime dPointRcvDt;
    private PType dPointRcvType;
    private int dPointRcvCode;
}

package com.samsung.dieat.subscribe.command.domain.aggregate.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class SubscribeId implements Serializable {
    private Integer subsUserCode;
    private Integer subsTgUserCode;
}


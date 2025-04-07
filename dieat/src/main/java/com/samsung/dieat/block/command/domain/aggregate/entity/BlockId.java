package com.samsung.dieat.block.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockId implements Serializable {
    private Integer blcUserCode;
    private Integer blcTgUserCode;
}



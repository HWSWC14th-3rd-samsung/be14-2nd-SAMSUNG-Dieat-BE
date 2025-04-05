package com.samsung.dieat.block.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_block")
@IdClass(BlockId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @Id
    @Column(name = "blc_user_code")
    private Integer blcUserCode;

    @Id
    @Column(name = "blc_tg_user_code")
    private Integer blcTgUserCode;
}


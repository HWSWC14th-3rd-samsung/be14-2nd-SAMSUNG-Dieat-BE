package com.samsung.dieat.subscribe.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_subscribe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SubscribeId.class)
public class Subscribe {

    @Id
    @Column(name = "subs_user_code")
    private Integer subsUserCode;

    @Id
    @Column(name = "subs_tg_user_code")
    private Integer subsTgUserCode;
}

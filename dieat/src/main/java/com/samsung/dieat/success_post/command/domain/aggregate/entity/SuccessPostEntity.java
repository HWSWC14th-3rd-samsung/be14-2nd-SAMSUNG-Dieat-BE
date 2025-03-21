package com.samsung.dieat.success_post.command.domain.aggregate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_success_post")
public class SuccessPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
}

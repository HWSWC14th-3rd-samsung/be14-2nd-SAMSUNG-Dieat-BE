package com.samsung.dieat.bookmark_category.command.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_bookmark_category")
public class bookMarkCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bm_ctgy_code")
    private int bmCtgyCode;

    @Column(name = "bm_ctgy_name")
    private String bmCtgyName;

    @Column(name = "user_code")
    private int userCode;


}

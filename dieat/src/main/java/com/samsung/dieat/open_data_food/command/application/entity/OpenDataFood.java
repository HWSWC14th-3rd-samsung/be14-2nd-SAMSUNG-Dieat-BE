package com.samsung.dieat.open_data_food.command.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_open_data_food")
@Getter
@Setter
public class OpenDataFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odf_code")
    private Integer odfCode;

    @Column(name = "odf_name")
    private String odfName;

    @Column(name = "odf_calories")
    private Float odfCalories;

    @Column(name = "odf_carbs")
    private Float odfCarbs;

    @Column(name = "odf_protein")
    private Float odfProtein;

    @Column(name = "odf_fat")
    private Float odfFat;

    @Column(name = "odf_sugar")
    private Float odfSugar;

    @Column(name = "odf_update_dt")
    private LocalDateTime odfUpdateDt;
}
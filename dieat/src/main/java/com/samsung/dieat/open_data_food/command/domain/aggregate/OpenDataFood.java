package com.samsung.dieat.open_data_food.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_open_data_food")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OpenDataFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odf_code")
    private Integer odfCode;

    @Column(name="odf_name", nullable = false)
    private String odfName;

    @Column(name = "odf_calories", nullable = false)
    private Float odfCalories;

    @Column(name = "odf_carbs")
    private Float odfCarbs;

    @Column(name = "odf_sugar")
    private Float odfSugar;

    @Column(name = "odf_protein")
    private Float odfProtein;

    @Column(name = "odf_fat")
    private Float odfFat;

    @Column(name = "odf_update_dt", nullable = false)
    private LocalDateTime odfUpdateDate;

    public void update(String odfName, Float odfCalories, Float odfCarbs, Float odfSugar, Float odfProtein, Float odfFat, LocalDateTime now) {

    }
}
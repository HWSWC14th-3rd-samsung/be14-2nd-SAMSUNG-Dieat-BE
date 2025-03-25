package com.samsung.dieat.user_data_food.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_user_data_food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class UserDataFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "udf_code")
    private Integer udfCode;

    @Column(name = "udf_name", nullable = false)
    private String udfName;

    @Column(name = "udf_sv_size", nullable = false)
    private Integer udfSvSize;

    @Column(name = "udf_uom", nullable = false)
    private String udfUom;

    @Column(name = "udf_sv_unit", nullable = false)
    private String udfSvUnit;

    @Column(name = "udf_calories", nullable = false)
    private Float udfCalories;

    @Column(name = "udf_carbs")
    private Float udfCarbs;

    @Column(name = "udf_sugar")
    private Float udfSugar;

    @Column(name = "udf_protein")
    private Float udfProtein;

    @Column(name = "udf_fat")
    private Float udfFat;

    @Column(name = "udf_acc_cnt")
    private Integer udfAccCnt = 0;

    @Column(name = "udf_inacc_cnt")
    private Integer udfInaccCnt = 0;

    @CreatedDate
    @Column(name = "udf_created_dt", nullable = false)
    private LocalDateTime udfCreatedDt;

    //    @ManyToOne
//    @JoinColumn(name = "user_code")
//    private UserEntity user;
    @Column(name = "user_code")
    private Integer userCode;

}


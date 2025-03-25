package com.samsung.dieat.diet_post.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_diet_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_code")
    private int dietCode;

    @Column(name = "diet_upload_dt", nullable = false)
    private LocalDateTime dietUploadDt;

    @Column(name = "diet_title", length = 255, nullable = false)
    private String dietTitle;

    @Column(name = "diet_conts", columnDefinition = "TEXT", nullable = false)
    private String dietConts;

    @Column(name = "diet_view_cnt", nullable = false)
    private int dietViewCnt = 0;

    @Column(name = "diet_like_cnt", nullable = false)
    private int dietLikeCnt = 0;

    @Column(name = "diet_cmt_cnt", nullable = false)
    private int dietCmtCnt = 0;

    @Column(name = "diet_calories", nullable = false)
    private float dietCalories = 0.0f;

    @Column(name = "diet_carbs", nullable = false)
    private float dietCarbs = 0.0f;

    @Column(name = "diet_sugar", nullable = false)
    private float dietSugar = 0.0f;

    @Column(name = "diet_protein", nullable = false)
    private float dietProtein = 0.0f;

    @Column(name = "diet_fat", nullable = false)
    private float dietFat = 0.0f;

    @Column(name = "diet_isdeleted", nullable = false)
    private boolean dietIsDeleted = false;

    @Column(name = "user_code", nullable = false)
    private int userCode;

    @PrePersist
    public void prePersist() {
        this.dietViewCnt = (this.dietViewCnt == 0) ? 0 : this.dietViewCnt;
        this.dietLikeCnt = (this.dietLikeCnt == 0) ? 0 : this.dietLikeCnt;
        this.dietCmtCnt = (this.dietCmtCnt == 0) ? 0 : this.dietCmtCnt;
        this.dietCalories = (this.dietCalories == 0) ? 0.0f : this.dietCalories;
        this.dietCarbs = (this.dietCarbs == 0) ? 0.0f : this.dietCarbs;
        this.dietSugar = (this.dietSugar == 0) ? 0.0f : this.dietSugar;
        this.dietProtein = (this.dietProtein == 0) ? 0.0f : this.dietProtein;
        this.dietFat = (this.dietFat == 0) ? 0.0f : this.dietFat;
        this.dietIsDeleted = (this.dietIsDeleted) ? true : false;
    }
}

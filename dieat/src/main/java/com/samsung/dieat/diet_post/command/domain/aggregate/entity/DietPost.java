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
    private int dietCode;
    private LocalDateTime dietUploadDt;
    private String dietTitle;
    private String dietConts;
    private int dietViewCnt;
    private int dietLikeCnt;
    private int dietCmtCnt;
    private int dietCalories;
    private int dietCarbs;
    private int dietProtein;
    private int dietFat;
    private int dietSugar;
    private boolean dietIsDeleted;
    private int userCode;
}
package com.samsung.dieat.meal.command.domain.aggregate.entity;

<<<<<<< HEAD
import com.samsung.dieat.meal.command.application.vo.MealCommandVO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

=======
import com.samsung.dieat.meal.command.application.dto.MealCommandDTO;
import jakarta.persistence.*;
import lombok.*;

>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_code")
    private int mealCode;

    @Column(name = "meal_dt")
    private String mealDt;

    @Column(name = "meal_title")
    private String mealTitle;

    @Column(name = "meal_desc")
    private String mealDesc;

    @Column(name = "meal_calories")
    private float mealCalories;

    @Column(name = "meal_carbs")
    private float mealCarbs;

    @Column(name = "meal_sugar")
    private float mealSugar;

    @Column(name = "meal_protein")
    private float mealProtein;

    @Column(name = "meal_fat")
    private float mealFat;

    @Column(name = "user_code")
    private int userCode;

<<<<<<< HEAD
    public void update(MealCommandVO vo) {
=======
    public void update(MealCommandDTO vo) {
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49
        this.mealDt = vo.getMealDt();
        this.mealTitle = vo.getMealTitle();
        this.mealDesc = vo.getMealDesc();
        this.mealCalories = vo.getMealCalories();
        this.mealCarbs = vo.getMealCarbs();
        this.mealSugar = vo.getMealSugar();
        this.mealProtein = vo.getMealProtein();
        this.mealFat = vo.getMealFat();
    }
}
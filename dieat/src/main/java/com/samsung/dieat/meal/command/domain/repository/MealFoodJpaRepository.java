package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFoodCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealFoodJpaRepository extends JpaRepository<MealFood, MealFoodCode> {

    @Query("SELECT mf FROM MealFood mf JOIN FETCH mf.meal m WHERE m.mealCode = :mealCode")
    List<MealFood> findByMealCodeWithMeal(@Param("mealCode") int mealCode);
}
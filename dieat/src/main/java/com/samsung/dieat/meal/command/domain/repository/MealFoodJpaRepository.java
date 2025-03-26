package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFoodCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealFoodJpaRepository extends JpaRepository<MealFood, Integer> {

    @Query("SELECT mf FROM MealFood mf JOIN FETCH mf.meal m WHERE m.mealCode = :mealCode")
    List<MealFood> findByMealCodeWithMeal(@Param("mealCode") int mealCode);

    void deleteByMeal_MealCode(int mealCode);
}
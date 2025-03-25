package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFoodCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface MealFoodJpaRepository extends JpaRepository<MealFood, MealFoodCode> {
=======
public interface MealFoodJpaRepository extends JpaRepository<MealFood, Integer> {
>>>>>>> 7dc9ca04fa32cdffef3b9e9dcadca0d1f7233d49

    @Query("SELECT mf FROM MealFood mf JOIN FETCH mf.meal m WHERE m.mealCode = :mealCode")
    List<MealFood> findByMealCodeWithMeal(@Param("mealCode") int mealCode);

    void deleteByMeal_MealCode(int mealCode);
}
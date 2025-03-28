package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFood;
import com.samsung.dieat.meal.command.domain.aggregate.entity.MealFoodCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealFoodJpaRepository extends JpaRepository<MealFood, Integer> {

    void deleteAllByMeal(Meal meal);
}
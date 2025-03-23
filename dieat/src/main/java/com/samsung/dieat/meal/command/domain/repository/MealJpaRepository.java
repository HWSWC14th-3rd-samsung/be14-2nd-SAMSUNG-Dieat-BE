package com.samsung.dieat.meal.command.domain.repository;

import com.samsung.dieat.meal.command.domain.aggregate.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealJpaRepository extends JpaRepository<Meal, Integer> {
}
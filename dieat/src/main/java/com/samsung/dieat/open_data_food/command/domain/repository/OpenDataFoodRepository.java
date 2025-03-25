package com.samsung.dieat.open_data_food.command.domain.repository;

import com.samsung.dieat.open_data_food.command.domain.aggregate.OpenDataFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenDataFoodRepository extends JpaRepository<OpenDataFood, Integer> {
}
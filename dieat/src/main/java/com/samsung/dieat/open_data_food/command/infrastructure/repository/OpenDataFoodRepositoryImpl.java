package com.samsung.dieat.open_data_food.command.infrastructure.repository;

import com.samsung.dieat.open_data_food.command.entity.OpenDataFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenDataFoodRepositoryImpl extends JpaRepository<OpenDataFood, Integer> {
    // JpaRepository에서 기본 CRUD 메서드를 제공
}
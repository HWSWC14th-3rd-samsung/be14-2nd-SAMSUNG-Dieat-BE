package com.samsung.dieat.user_data_food.command.infrastructure;

import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataFoodRepository extends JpaRepository<UserDataFood, Integer> {
    List<UserDataFood> findAllByUserCode(Integer userCode);
}

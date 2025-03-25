package com.samsung.dieat.user_data_food.command.domain.repository;

import com.samsung.dieat.user_data_food.command.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
}
package com.samsung.dieat.member.command.domain.repository;

<<<<<<< HEAD
import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface  UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);
}
=======

import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
}
>>>>>>> 2cbde92212667ea14e50afb39161f4db0b222b19

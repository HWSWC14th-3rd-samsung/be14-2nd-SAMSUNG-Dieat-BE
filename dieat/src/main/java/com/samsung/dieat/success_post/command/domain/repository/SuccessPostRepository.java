package com.samsung.dieat.success_post.command.domain.repository;

import com.samsung.dieat.success_post.command.domain.aggregate.entity.SuccessPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessPostRepository extends JpaRepository<SuccessPostEntity, Integer> {
}

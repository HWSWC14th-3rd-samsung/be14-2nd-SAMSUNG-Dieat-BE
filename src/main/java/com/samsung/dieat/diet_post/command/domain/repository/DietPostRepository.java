package com.samsung.dieat.diet_post.command.domain.repository;

import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietPostRepository extends JpaRepository<DietPost, Integer> {
}

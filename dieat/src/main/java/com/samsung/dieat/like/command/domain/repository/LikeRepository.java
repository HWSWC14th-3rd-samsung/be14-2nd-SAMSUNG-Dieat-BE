package com.samsung.dieat.like.command.domain.repository;

import com.samsung.dieat.like.command.domain.entity.Like;
import com.samsung.dieat.like.command.domain.entity.Like.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {
}

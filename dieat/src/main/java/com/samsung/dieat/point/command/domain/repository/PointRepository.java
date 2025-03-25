package com.samsung.dieat.point.command.domain.repository;

import com.samsung.dieat.point.command.domain.aggregate.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Integer> {
}

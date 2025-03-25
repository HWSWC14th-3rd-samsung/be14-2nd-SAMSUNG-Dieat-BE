package com.samsung.dieat.point.command.domain.repository;

import com.samsung.dieat.point.command.domain.aggregate.entity.DailyPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DailyPointRepository extends JpaRepository<DailyPointEntity, Integer> {
    List<DailyPointEntity> findByCreatedAtBefore(LocalDateTime time);
}

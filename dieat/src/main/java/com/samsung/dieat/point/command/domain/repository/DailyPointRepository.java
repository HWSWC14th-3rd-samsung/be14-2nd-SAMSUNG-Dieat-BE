package com.samsung.dieat.point.command.domain.repository;

import com.samsung.dieat.point.command.domain.aggregate.entity.DailyPointEntity;
import com.samsung.dieat.point.command.domain.aggregate.entity.PointEntity;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DailyPointRepository extends JpaRepository<DailyPointEntity, Integer> {
    List<DailyPointEntity> findByCreatedAtBefore(LocalDateTime time);
}

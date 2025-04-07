package com.samsung.dieat.subscribe.command.domain.repository;

import com.samsung.dieat.subscribe.command.domain.aggregate.entity.Subscribe;
import com.samsung.dieat.subscribe.command.domain.aggregate.entity.SubscribeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, SubscribeId> {
}

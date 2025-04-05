package com.samsung.dieat.block.command.domain.repository;

import com.samsung.dieat.block.command.domain.aggregate.entity.Block;
import com.samsung.dieat.block.command.domain.aggregate.entity.BlockId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, BlockId> {
}

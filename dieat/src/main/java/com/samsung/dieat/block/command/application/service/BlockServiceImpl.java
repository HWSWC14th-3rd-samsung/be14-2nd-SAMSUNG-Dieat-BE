package com.samsung.dieat.block.command.application.service;

import com.samsung.dieat.block.command.domain.aggregate.entity.Block;
import com.samsung.dieat.block.command.domain.aggregate.entity.BlockId;
import com.samsung.dieat.block.command.domain.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public void registerBlock(Integer requesterUserCode, Integer targetUserCode) {
        BlockId id = new BlockId(requesterUserCode, targetUserCode);

        if (!blockRepository.existsById(id)) {
            Block block = new Block(requesterUserCode, targetUserCode);
            blockRepository.save(block);
        }
    }
}


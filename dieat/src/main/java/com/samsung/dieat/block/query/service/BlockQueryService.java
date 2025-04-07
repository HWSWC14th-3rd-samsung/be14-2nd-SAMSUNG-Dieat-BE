package com.samsung.dieat.block.query.service;

import com.samsung.dieat.block.query.dao.BlockMapper;
import com.samsung.dieat.block.query.dto.BlockedUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockQueryService {

    private final BlockMapper blockMapper;

    @Autowired
    public BlockQueryService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<BlockedUserVO> getBlockedUsers(int userCode) {
        return blockMapper.selectBlockedUsersByUserCode(userCode);
    }
}

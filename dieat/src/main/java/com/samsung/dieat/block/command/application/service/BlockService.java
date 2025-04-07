package com.samsung.dieat.block.command.application.service;

public interface BlockService {
    void registerBlock(Integer requesterUserCode, Integer targetUserCode);

    void cancelBlock(Integer requesterUserCode, Integer targetUserCode);

}


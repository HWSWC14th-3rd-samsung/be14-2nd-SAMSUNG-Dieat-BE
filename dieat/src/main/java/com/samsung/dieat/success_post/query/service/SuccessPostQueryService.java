package com.samsung.dieat.success_post.query.service;

import com.samsung.dieat.success_post.query.dao.SuccPostMapper;
import com.samsung.dieat.success_post.query.dto.SuccPostQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessPostQueryService {

    private final SuccPostMapper succPostMapper;

    @Autowired
    public SuccessPostQueryService(SuccPostMapper succPostMapper) {
        this.succPostMapper = succPostMapper;
    }

    public List<SuccPostQueryDTO> getSuccPostForUserCode(int userCode) {
        return succPostMapper.getSuccPostForUserCode(userCode);
    }

    public List<SuccPostQueryDTO> getSuccPostForTitle(String succTitle) {
        return succPostMapper.getSuccPostForTitle(succTitle);
    }
}

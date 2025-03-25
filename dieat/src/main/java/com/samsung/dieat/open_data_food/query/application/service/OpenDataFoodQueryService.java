package com.samsung.dieat.open_data_food.query.application.service;

import com.samsung.dieat.open_data_food.query.dao.mapper.OpenDataFoodMapper;
import com.samsung.dieat.open_data_food.query.dto.response.ResponseOpenDataFood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenDataFoodQueryService {

    private final OpenDataFoodMapper odfMapper;

    /**
     * 전체 데이터 조회
     */
    public List<ResponseOpenDataFood> findAll() {
        return odfMapper.findAll();
    }

    /**
     * odfCode로 단건 조회
     */
    public ResponseOpenDataFood findByOdfCode(Integer odfCode) {
        return odfMapper.findByOdfCode(odfCode);
    }

    /**
     * 키워드 리스트 기반 like 검색
     */
    public List<ResponseOpenDataFood> findByMultipleKeywords(List<String> keywords) {
        return odfMapper.findByMultipleKeywords(keywords);
    }
}
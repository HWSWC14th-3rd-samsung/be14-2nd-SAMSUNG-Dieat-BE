package com.samsung.dieat.open_data_food.query.service;

import com.samsung.dieat.open_data_food.query.dao.OpenDataFoodMapper;
import com.samsung.dieat.open_data_food.query.dto.ResponseOdfName;
import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenDataFoodQueryService {

    private final OpenDataFoodMapper odfMapper;

    // 데이터 전체 조회
    public List<ResponseOpenDataFood> findAll() { return odfMapper.findAll(); }

    // 코드로 조회
    public ResponseOpenDataFood getOdfByOdfCode(int odfCode) { return odfMapper.findByOdfCode(odfCode); }

    // 이름으로 조회
    public List<ResponseOdfName> getOdfByLikeName(String keyword) {
        List<String> keywords = Arrays.asList(keyword.split("\\s+")); // 공백 기준으로 키워드 분리
        return odfMapper.findByMultipleKeywords(keywords);
    }
}
package com.samsung.dieat.open_data_food.query.service;

import com.samsung.dieat.open_data_food.query.dao.OpenDataFoodMapper;
import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenDataFoodQueryService {

    private final OpenDataFoodMapper mapper;

    public OpenDataFoodQueryService(OpenDataFoodMapper mapper) {
        this.mapper = mapper;
    }

    public List<ResponseOpenDataFood> findAll() {
        return mapper.findAll();
    }

    public ResponseOpenDataFood findByCode(int code) {
        return mapper.findByCode(code);
    }
}
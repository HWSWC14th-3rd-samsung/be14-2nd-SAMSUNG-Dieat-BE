package com.samsung.dieat.open_data_food.query.service;

import lombok.RequiredArgsConstructor;
import com.samsung.dieat.open_data_food.query.dao.OpenDataFoodMapper;
import com.samsung.dieat.open_data_food.query.dto.OpenDataFoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenDataFoodService {

    private final OpenDataFoodMapper mapper;

    public List<OpenDataFoodDto> getAllFoods() {
        return mapper.findAll();
    }

    public OpenDataFoodDto getFoodById(Integer odfCode) {
        return mapper.findById(odfCode);
    }
}

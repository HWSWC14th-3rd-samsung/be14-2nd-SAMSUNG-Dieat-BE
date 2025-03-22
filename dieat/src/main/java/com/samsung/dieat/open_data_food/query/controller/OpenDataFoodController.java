package com.samsung.dieat.open_data_food.query.controller;

import lombok.RequiredArgsConstructor;
import com.samsung.dieat.open_data_food.query.dto.OpenDataFoodDto;
import com.samsung.dieat.open_data_food.query.service.OpenDataFoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/foods")
@RequiredArgsConstructor
public class OpenDataFoodController {

    private final OpenDataFoodService openDataFoodService;

    @GetMapping
    public List<OpenDataFoodDto> findAll() {
        return openDataFoodService.getAllFoods();
    }

    @GetMapping("/{odfCode}")
    public OpenDataFoodDto findById(@PathVariable Integer odfCode) {
        return openDataFoodService.getFoodById(odfCode);
    }
}
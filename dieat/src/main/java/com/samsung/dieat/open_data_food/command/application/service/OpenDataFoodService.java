package com.samsung.dieat.open_data_food.command.application.service;

import com.samsung.dieat.open_data_food.command.dto.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.UpdateOpenDataFoodRequest;

public interface OpenDataFoodService {
    InsertOpenDataFoodResponse insert(InsertOpenDataFoodRequest request);
    InsertOpenDataFoodResponse update(UpdateOpenDataFoodRequest request);
    DeleteOpenDataFoodResponse delete(Integer odfCode);
}
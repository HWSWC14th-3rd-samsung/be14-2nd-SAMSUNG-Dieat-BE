package com.samsung.dieat.open_data_food.command.application.service;

import com.samsung.dieat.open_data_food.command.dto.request.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.request.UpdateOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.response.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.response.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.common.dto.CommonResponse;

import java.util.List;

public interface OpenDataFoodService {
    List<InsertOpenDataFoodResponse> insert(List<InsertOpenDataFoodRequest> requests);
    CommonResponse<InsertOpenDataFoodResponse> update(UpdateOpenDataFoodRequest request);
    CommonResponse<DeleteOpenDataFoodResponse> delete(Integer odfCode);
}
package com.samsung.dieat.open_data_food.command.application.service;

import com.samsung.dieat.open_data_food.command.domain.repository.OpenDataFoodRepository;
import com.samsung.dieat.open_data_food.command.dto.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.UpdateOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.entity.OpenDataFood;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OpenDataFoodServiceImpl implements OpenDataFoodService {

    private final OpenDataFoodRepository repository;

    public OpenDataFoodServiceImpl(OpenDataFoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public InsertOpenDataFoodResponse insert(InsertOpenDataFoodRequest request) {
        OpenDataFood food = new OpenDataFood(
                request.getName(), request.getCalories(), request.getCarbs(),
                request.getSugar(), request.getProtein(), request.getFat(),
                LocalDateTime.now()
        );
        OpenDataFood saved = repository.save(food);
        return new InsertOpenDataFoodResponse(saved.getCode(), "등록 완료");
    }

    @Override
    public InsertOpenDataFoodResponse update(UpdateOpenDataFoodRequest request) {
        OpenDataFood food = repository.findById(request.getCode())
                .orElseThrow(() -> new IllegalArgumentException("음식 정보가 존재하지 않습니다."));
        food.update(request.getName(), request.getCalories(), request.getCarbs(),
                request.getSugar(), request.getProtein(), request.getFat(), LocalDateTime.now());
        return new InsertOpenDataFoodResponse(food.getCode(), "수정 완료");
    }

    @Override
    public DeleteOpenDataFoodResponse delete(Integer code) {
        repository.deleteById(code);
        return new DeleteOpenDataFoodResponse("삭제 완료");
    }
}
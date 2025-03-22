package com.samsung.dieat.open_data_food.command.application.service;

import lombok.RequiredArgsConstructor;
import com.samsung.dieat.open_data_food.command.application.dto.OpenDataFoodDto;
import com.samsung.dieat.open_data_food.command.application.entity.OpenDataFood;
import com.samsung.dieat.open_data_food.command.domain.repository.OpenDataFoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class OpenDataFoodService {

    private final OpenDataFoodRepository openDataFoodRepository;

    public OpenDataFood createFood(OpenDataFoodDto dto) {
        OpenDataFood entity = new OpenDataFood();
        entity.setOdfName(dto.getOdfName());
        entity.setOdfCalories(dto.getOdfCalories());
        entity.setOdfCarbs(dto.getOdfCarbs());
        entity.setOdfProtein(dto.getOdfProtein());
        entity.setOdfFat(dto.getOdfFat());
        entity.setOdfSugar(dto.getOdfSugar());
        entity.setOdfUpdateDt(LocalDateTime.now());
        return openDataFoodRepository.save(entity);
    }

    public OpenDataFood updateFood(OpenDataFoodDto dto) {
        OpenDataFood entity = openDataFoodRepository.findById(dto.getOdfCode())
                .orElseThrow(() -> new RuntimeException("해당 코드의 음식이 존재하지 않습니다."));
        entity.setOdfName(dto.getOdfName());
        entity.setOdfCalories(dto.getOdfCalories());
        entity.setOdfCarbs(dto.getOdfCarbs());
        entity.setOdfProtein(dto.getOdfProtein());
        entity.setOdfFat(dto.getOdfFat());
        entity.setOdfSugar(dto.getOdfSugar());
        entity.setOdfUpdateDt(LocalDateTime.now());
        return openDataFoodRepository.save(entity);
    }

    public void deleteFood(Integer odfCode) {
        openDataFoodRepository.deleteById(odfCode);
    }
}
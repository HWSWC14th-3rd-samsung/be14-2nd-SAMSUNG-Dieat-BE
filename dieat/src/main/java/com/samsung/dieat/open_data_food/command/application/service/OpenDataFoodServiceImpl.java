package com.samsung.dieat.open_data_food.command.application.service;

import com.samsung.dieat.open_data_food.command.domain.repository.OpenDataFoodRepository;
import com.samsung.dieat.open_data_food.command.dto.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.UpdateOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.entity.OpenDataFood;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OpenDataFoodServiceImpl implements OpenDataFoodService {

    private final OpenDataFoodRepository odfRepository;

    @Override
    public InsertOpenDataFoodResponse insert(InsertOpenDataFoodRequest request) {
        OpenDataFood odf = new OpenDataFood( null,
                request.getOdfName(), request.getOdfCalories(), request.getOdfCarbs(),
                request.getOdfSugar(), request.getOdfProtein(), request.getOdfFat(),
                LocalDateTime.now()
        );
        OpenDataFood saved = odfRepository.save(odf);
        return new InsertOpenDataFoodResponse(saved.getOdfCode(), "등록 완료");
    }

    @Override
    public InsertOpenDataFoodResponse update(UpdateOpenDataFoodRequest request) {
        if (request.getOdfCode() == null) {
            throw new IllegalArgumentException("수정하려면 odfCode가 필요합니다.");
        }

        OpenDataFood target = odfRepository.findById(request.getOdfCode())
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 데이터가 없습니다."));

        if (request.getOdfName() != null) target.setOdfName(request.getOdfName());
        if (request.getOdfCalories() != null) target.setOdfCalories(request.getOdfCalories());
        if (request.getOdfCarbs() != null) target.setOdfCarbs(request.getOdfCarbs());
        if (request.getOdfSugar() != null) target.setOdfSugar(request.getOdfSugar());
        if (request.getOdfProtein() != null) target.setOdfProtein(request.getOdfProtein());
        if (request.getOdfFat() != null) target.setOdfFat(request.getOdfFat());

        OpenDataFood saved = odfRepository.save(target);
        return new InsertOpenDataFoodResponse(saved.getOdfCode(), "수정 완료");
    }

    @Override
    public DeleteOpenDataFoodResponse delete(Integer odfCode) {
        odfRepository.deleteById(odfCode);
        return new DeleteOpenDataFoodResponse("삭제 완료");
    }
}
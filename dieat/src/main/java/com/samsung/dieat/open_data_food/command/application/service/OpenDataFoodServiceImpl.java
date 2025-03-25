package com.samsung.dieat.open_data_food.command.application.service;

import com.samsung.dieat.open_data_food.command.domain.aggregate.OpenDataFood;
import com.samsung.dieat.open_data_food.command.domain.repository.OpenDataFoodRepository;
import com.samsung.dieat.open_data_food.command.dto.request.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.request.UpdateOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.response.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.response.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.common.dto.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OpenDataFoodServiceImpl implements OpenDataFoodService {

    private final OpenDataFoodRepository odfRepository;

    @Override
    public List<InsertOpenDataFoodResponse> insert(List<InsertOpenDataFoodRequest> requests) {
        List<InsertOpenDataFoodResponse> responses = new ArrayList<>();

        for (InsertOpenDataFoodRequest req : requests) {
            OpenDataFood entity = new OpenDataFood(
                    null,
                    req.getOdfName(),
                    req.getOdfCalories(),
                    req.getOdfCarbs(),
                    req.getOdfSugar(),
                    req.getOdfProtein(),
                    req.getOdfFat(),
                    LocalDateTime.now()
            );

            OpenDataFood saved = odfRepository.save(entity);

            responses.add(new InsertOpenDataFoodResponse(saved.getOdfCode(), "등록 완료"));
        }

        return responses;
    }

    @Override
    public CommonResponse<InsertOpenDataFoodResponse> update(UpdateOpenDataFoodRequest request) {
        if (request.getOdfCode() == null) {
            return CommonResponse.fail("수정하려면 odfCode가 필요합니다.", 400);
        }

        Optional<OpenDataFood> optional = odfRepository.findById(request.getOdfCode());
        if (optional.isEmpty()) {
            return CommonResponse.fail("해당 ID의 데이터가 없습니다.", 404);
        }

        OpenDataFood target = optional.get();

        Optional.ofNullable(request.getOdfName()).ifPresent(target::setOdfName);
        Optional.ofNullable(request.getOdfCalories()).ifPresent(target::setOdfCalories);
        Optional.ofNullable(request.getOdfCarbs()).ifPresent(target::setOdfCarbs);
        Optional.ofNullable(request.getOdfSugar()).ifPresent(target::setOdfSugar);
        Optional.ofNullable(request.getOdfProtein()).ifPresent(target::setOdfProtein);
        Optional.ofNullable(request.getOdfFat()).ifPresent(target::setOdfFat);

        OpenDataFood saved = odfRepository.save(target);

        return CommonResponse.success(
                new InsertOpenDataFoodResponse(saved.getOdfCode(), "수정 완료"),
                "데이터 수정 성공"
        );
    }

    @Override
    public CommonResponse<DeleteOpenDataFoodResponse> delete(Integer odfCode) {
        Optional<OpenDataFood> optional = odfRepository.findById(odfCode);
        if (optional.isEmpty()) {
            return CommonResponse.fail("삭제할 ID가 없습니다.", 404);
        }

        odfRepository.deleteById(odfCode);

        return CommonResponse.<DeleteOpenDataFoodResponse>success(
                new DeleteOpenDataFoodResponse("삭제 완료"),
                "데이터 삭제 성공"
        );
    }
}
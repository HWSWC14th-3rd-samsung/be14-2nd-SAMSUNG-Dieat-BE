package com.samsung.dieat.open_data_food.command.application.controller;

import com.samsung.dieat.open_data_food.command.application.service.OpenDataFoodService;
import com.samsung.dieat.open_data_food.command.dto.request.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.request.UpdateOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.response.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.response.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.common.dto.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/open-data-food")
@RequiredArgsConstructor
public class OpenDataFoodController {

    private final OpenDataFoodService odfService;

    @PostMapping
    public ResponseEntity<CommonResponse<List<InsertOpenDataFoodResponse>>> insert(
            @RequestBody List<InsertOpenDataFoodRequest> requests) {

        List<InsertOpenDataFoodResponse> responses = odfService.insert(requests);
        return ResponseEntity.ok(CommonResponse.success(responses));
    }

    @PutMapping("/update/{odfCode}")
    public ResponseEntity<CommonResponse<InsertOpenDataFoodResponse>> update(
            @PathVariable Integer odfCode,
            @RequestBody UpdateOpenDataFoodRequest request) {
        request.setOdfCode(odfCode); // ★ 여기에서 설정!
        return ResponseEntity.ok(odfService.update(request));
    }

    @DeleteMapping("/delete/{odfCode}")
    public ResponseEntity<CommonResponse<DeleteOpenDataFoodResponse>> delete(
            @PathVariable Integer odfCode) {
        return ResponseEntity.ok(odfService.delete(odfCode));
    }
}

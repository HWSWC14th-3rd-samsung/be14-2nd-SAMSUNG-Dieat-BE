package com.samsung.dieat.open_data_food.query.application.controller;

import com.samsung.dieat.open_data_food.common.dto.CommonResponse;
import com.samsung.dieat.open_data_food.query.application.service.OpenDataFoodQueryService;
import com.samsung.dieat.open_data_food.query.dto.response.ResponseOpenDataFood;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/open-data-food")
@RequiredArgsConstructor
public class OpenDataFoodQueryController {

    private final OpenDataFoodQueryService odfQueryService;

    /**
     * 전체 조회
     */
    @GetMapping("")
    public ResponseEntity<CommonResponse<List<ResponseOpenDataFood>>> findAll() {
        List<ResponseOpenDataFood> result = odfQueryService.findAll();
        return ResponseEntity.ok(CommonResponse.success(result));
    }

    /**
     * ID 기준 단건 조회
     */
    @GetMapping("/{odfCode}")
    public ResponseEntity<CommonResponse<ResponseOpenDataFood>> findByCode(@PathVariable Integer odfCode) {
        ResponseOpenDataFood result = odfQueryService.findByOdfCode(odfCode);
        return ResponseEntity.ok(CommonResponse.success(result));
    }

    /**
     * 키워드 포함 검색
     */
    @GetMapping("/like")
    public ResponseEntity<CommonResponse<List<ResponseOpenDataFood>>> findByKeywords(@RequestParam List<String> keywords) {
        List<ResponseOpenDataFood> result = odfQueryService.findByMultipleKeywords(keywords);
        return ResponseEntity.ok(CommonResponse.success(result));
    }
}
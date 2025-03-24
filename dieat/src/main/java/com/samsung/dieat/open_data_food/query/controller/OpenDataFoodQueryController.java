package com.samsung.dieat.open_data_food.query.controller;

import com.samsung.dieat.open_data_food.query.dto.ResponseOdfName;
import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import com.samsung.dieat.open_data_food.query.service.OpenDataFoodQueryService;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open_data_food")
@RequiredArgsConstructor
public class OpenDataFoodQueryController {

    private final OpenDataFoodQueryService odfQueryService;

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<ResponseOpenDataFood>> getAll() {
        return ResponseEntity.ok(odfQueryService.findAll());
    }

    @GetMapping("/code/{odfCode}")
    public ResponseEntity<ResponseOpenDataFood> getOpenDataFoodByOdfCode(@PathVariable int odfCode) {
        ResponseOpenDataFood result = odfQueryService.getOdfByOdfCode(odfCode);
        return ResponseEntity.status(HttpStatus.OK).body(result);   // 200 + 데이터 반환
    }

    @GetMapping("/like/{likeName}")
    public ResponseEntity<List<ResponseOdfName>> getOdfByLikeName(@PathVariable String likeName) {
        List<ResponseOdfName> result = odfQueryService.getOdfByLikeName(likeName);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).build();    // 검색 결과가 없어도 OK
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
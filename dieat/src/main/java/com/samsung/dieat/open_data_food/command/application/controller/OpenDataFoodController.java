package com.samsung.dieat.open_data_food.command.application.controller;

import com.samsung.dieat.open_data_food.command.application.service.OpenDataFoodService;
import com.samsung.dieat.open_data_food.command.domain.repository.OpenDataFoodRepository;
import com.samsung.dieat.open_data_food.command.dto.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.UpdateOpenDataFoodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open_data_food")
@RequiredArgsConstructor
public class OpenDataFoodController {

    private final OpenDataFoodService odfService;
    private final OpenDataFoodRepository odfRepository;

    @PostMapping
    public ResponseEntity<InsertOpenDataFoodResponse> insert(@RequestBody InsertOpenDataFoodRequest request) {
        return ResponseEntity.ok(odfService.insert(request));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<DeleteOpenDataFoodResponse> delete(@PathVariable Integer code) {
        return ResponseEntity.ok(odfService.delete(code));
    }

    @PutMapping("/code/{code}")
    public ResponseEntity<?> updateByCode(@PathVariable Integer code,
                                          @RequestBody UpdateOpenDataFoodRequest request) {
        request.setOdfCode(code); // body에 없어도 여기서 강제 세팅
        return ResponseEntity.ok(odfService.update(request));
    }
}
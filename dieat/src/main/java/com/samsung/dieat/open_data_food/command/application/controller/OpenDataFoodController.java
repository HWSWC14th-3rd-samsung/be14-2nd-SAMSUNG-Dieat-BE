package com.samsung.dieat.open_data_food.command.application.controller;

import lombok.RequiredArgsConstructor;
import com.samsung.dieat.open_data_food.command.application.dto.OpenDataFoodDto;
import com.samsung.dieat.open_data_food.command.application.entity.OpenDataFood;
import com.samsung.dieat.open_data_food.command.application.service.OpenDataFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/foods")
@RequiredArgsConstructor
public class OpenDataFoodController {

    private final OpenDataFoodService openDataFoodService;

    // 생성
    @PostMapping
    public ResponseEntity<OpenDataFood> create(@RequestBody OpenDataFoodDto dto) {
        OpenDataFood created = openDataFoodService.createFood(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // 수정
    @PutMapping("/{odfCode}")
    public ResponseEntity<OpenDataFood> update(@PathVariable Integer odfCode,
                                               @RequestBody OpenDataFoodDto dto) {
        dto.setOdfCode(odfCode);
        OpenDataFood updated = openDataFoodService.updateFood(dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/{odfCode}")
    public ResponseEntity<Void> delete(@PathVariable Integer odfCode) {
        openDataFoodService.deleteFood(odfCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
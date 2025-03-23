package com.samsung.dieat.open_data_food.command.application.controller;

import com.samsung.dieat.open_data_food.command.application.service.OpenDataFoodService;
import com.samsung.dieat.open_data_food.command.dto.DeleteOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodRequest;
import com.samsung.dieat.open_data_food.command.dto.InsertOpenDataFoodResponse;
import com.samsung.dieat.open_data_food.command.dto.UpdateOpenDataFoodRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open_data_food")
public class OpenDataFoodController {

    private final OpenDataFoodService service;

    public OpenDataFoodController(OpenDataFoodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InsertOpenDataFoodResponse> insert(@RequestBody InsertOpenDataFoodRequest request) {
        return ResponseEntity.ok(service.insert(request));
    }

    @PutMapping
    public ResponseEntity<InsertOpenDataFoodResponse> update(@RequestBody UpdateOpenDataFoodRequest request) {
        return ResponseEntity.ok(service.update(request));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<DeleteOpenDataFoodResponse> delete(@PathVariable Integer code) {
        return ResponseEntity.ok(service.delete(code));
    }
}
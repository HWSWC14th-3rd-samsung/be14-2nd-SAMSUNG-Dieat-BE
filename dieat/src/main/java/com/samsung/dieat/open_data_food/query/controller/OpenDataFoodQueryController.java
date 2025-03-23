package com.samsung.dieat.open_data_food.query.controller;

import com.samsung.dieat.open_data_food.query.dto.ResponseOpenDataFood;
import com.samsung.dieat.open_data_food.query.service.OpenDataFoodQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open_data_food")
public class OpenDataFoodQueryController {

    private final OpenDataFoodQueryService service;

    public OpenDataFoodQueryController(OpenDataFoodQueryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResponseOpenDataFood>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ResponseOpenDataFood> getByCode(@PathVariable int code) {
        return ResponseEntity.ok(service.findByCode(code));
    }
}
package com.samsung.dieat.user_data_food.query.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;
import com.samsung.dieat.user_data_food.query.service.UserDataFoodQueryService;

@RestController
@RequestMapping(value = "/user-data-food")
@RequiredArgsConstructor
public class UserDataFoodQueryController {

    private final UserDataFoodQueryService userDataFoodQueryService;

    @GetMapping("/{udfCode}/fooddata")
    public ResponseEntity<UserDataFoodDTO> getUserDataFood(@PathVariable int udfCode) {
        System.out.println(udfCode);
        UserDataFoodDTO dto = userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
        return ResponseEntity.ok(dto);
    }
}

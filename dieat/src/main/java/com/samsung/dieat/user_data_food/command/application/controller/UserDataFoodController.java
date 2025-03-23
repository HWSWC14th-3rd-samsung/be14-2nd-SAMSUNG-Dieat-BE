package com.samsung.dieat.user_data_food.command.application.controller;

import com.samsung.dieat.user_data_food.command.application.service.UserDataFoodService;
import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodRequest;
import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodResponse;
import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-data-food")
public class UserDataFoodController {

    private final UserDataFoodService userDataFoodService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<InsertUserDataFoodResponse> saveUserDataFood(@Valid @RequestBody InsertUserDataFoodRequest request) {
        UserDataFood userDataFood = userDataFoodService.saveUserDataFood(request);
        return ResponseEntity.ok(modelMapper.map(userDataFood, InsertUserDataFoodResponse.class));
    }

    @DeleteMapping("/{udfCode}")
    public ResponseEntity<Void> deleteUserDataFood(@PathVariable Integer udfCode) {
        userDataFoodService.deleteUserDataFood(udfCode);
        return ResponseEntity.ok().build();
    }

}

package com.samsung.dieat.user_data_food.command.application.controller;

import com.samsung.dieat.user_data_food.command.application.service.UserDataFoodService;
import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodRequest;
import com.samsung.dieat.user_data_food.command.dto.InsertUserDataFoodResponse;
import com.samsung.dieat.user_data_food.command.entity.UserDataFood;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;
import com.samsung.dieat.user_data_food.query.service.UserDataFoodQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-data-food/query")
public class UserDataFoodController {

    private final UserDataFoodService userDataFoodService;
    private final UserDataFoodQueryService userDataFoodQueryService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<InsertUserDataFoodResponse> saveUserDataFood(@Valid @RequestBody InsertUserDataFoodRequest request) {
        UserDataFood userDataFood = userDataFoodService.saveUserDataFood(request);
        return ResponseEntity.ok(modelMapper.map(userDataFood, InsertUserDataFoodResponse.class));
    }

    @DeleteMapping("/delete/{udfCode}")
    public ResponseEntity<Void> deleteUserDataFood(@PathVariable Integer udfCode) {
        userDataFoodService.deleteUserDataFood(udfCode);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{udfCode}")
    public ResponseEntity<UserDataFoodDTO> getUserDataFood(@PathVariable int udfCode) {
        UserDataFoodDTO dto = userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
        return ResponseEntity.ok(dto);
    }


}

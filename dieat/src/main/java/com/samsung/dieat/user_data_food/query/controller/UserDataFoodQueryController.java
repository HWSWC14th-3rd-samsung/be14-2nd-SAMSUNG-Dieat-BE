package com.samsung.dieat.user_data_food.query.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samsung.dieat.user_data_food.query.dto.UserDataFoodDTO;
import com.samsung.dieat.user_data_food.query.service.UserDataFoodQueryService;

@RestController
@RequestMapping("/user-data-food")
@RequiredArgsConstructor
public class UserDataFoodQueryController {

    private final UserDataFoodQueryService userDataFoodQueryService;

    @GetMapping("/{udfCode}")
    public UserDataFoodDTO getUserDataFood(@PathVariable int udfCode) {
        System.out.println(udfCode);
        return userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
    }
}

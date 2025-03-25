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

<<<<<<< HEAD
    @GetMapping("/{udfCode}")
    public UserDataFoodDTO getUserDataFood(@PathVariable int udfCode) {
        System.out.println(udfCode);
        return userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
=======
    @GetMapping("/code/{udfCode}")
    public ResponseEntity<UserDataFoodDTO> getUserDataFoodByUdfCode(@PathVariable int udfCode) {
        UserDataFoodDTO result = userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
        return ResponseEntity.status(HttpStatus.OK).body(result);   // 200 + 데이터 반환
        /* 설명: 결과값이 없어도 OK를 보내는 이유

         *   결과값이 없는 것이지 잘못된 요청이 들어온 것이 아니기 때문
         *   하지만 어떻게 처리할 지 추가 논의 필요
         *   1. 프론트에서 결과값이 없는 경우 처리
         *   2. Exception을 만들어서 처리*/


        /* 설명: Exception을 만들어서 처리하는 방법*/
        /*@GetMapping("/{udfCode}")
        public ResponseEntity<UserDataFoodDTO> getUserDataFood(@PathVariable int udfCode) {
            UserDataFoodDTO dto = userDataFoodQueryService.getUserDataFoodByUdfCode(udfCode);
            if (dto == null) {
                throw new ResourceNotFoundException("UserDataFood not found: " + udfCode);
            }
            return ResponseEntity.ok(dto);
        }*/
        /* 설명: 컨트롤러를 위 코드로 대체
        *   이후 아래 GlobalExceptionHandler 처리*/

        /*@RestControllerAdvice
        public class GlobalExceptionHandler {

            @ExceptionHandler(ResourceNotFoundException.class)
            public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }*/
>>>>>>> 2cbde92212667ea14e50afb39161f4db0b222b19
    }
}

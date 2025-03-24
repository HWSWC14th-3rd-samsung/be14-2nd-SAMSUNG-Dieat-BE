package com.samsung.dieat.user_data_food.query.controller;

import com.samsung.dieat.user_data_food.query.dto.ResponseUdfName;
import com.samsung.dieat.user_data_food.query.dto.ResponseUserDataFood;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    }

    @GetMapping("/like/{likeName}")
    public ResponseEntity<List<ResponseUdfName>> getUserDataFoodByLikeName(@PathVariable String likeName) {
        List<ResponseUdfName> result = userDataFoodQueryService.getUserDataFoodByLikeName(likeName);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).build();    // 검색 결과가 없어도 OK
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/name/{udfName}")
    public ResponseEntity<List<ResponseUserDataFood>> getUserDataFoodWithNickname(@PathVariable String udfName) {
        List<ResponseUserDataFood> result = userDataFoodQueryService.getUserDataFoodWithNickname(udfName);
        return ResponseEntity.ok(result);
    }

}

package com.samsung.dieat.open_data_food.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommonResponse<T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final int statusCode;
    private final LocalDateTime timestamp;

    private CommonResponse(boolean success, String message, T data, int statusCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>(true, message, data, 200);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(true, "요청 성공", data, 200);
    }

    public static <T> CommonResponse<T> fail(String message, int statusCode) {
        return new CommonResponse<>(false, message, null, statusCode);
    }

    public static <T> CommonResponse<T> fail(String message) {
        return new CommonResponse<>(false, message, null, 400);
    }
}
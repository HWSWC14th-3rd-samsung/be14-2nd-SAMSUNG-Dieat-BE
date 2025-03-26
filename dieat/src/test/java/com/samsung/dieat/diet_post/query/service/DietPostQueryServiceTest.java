package com.samsung.dieat.diet_post.query.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DietPostQueryServiceTest {

    @Autowired
    private DietPostQueryService dietPostQueryService;

    @DisplayName("모든 식단 게시물 조회")
    @Test
    void testGetAllDietPosts() {
        Assertions.assertDoesNotThrow(
                () -> dietPostQueryService.getAllDietPosts());
    }
}
package com.samsung.dieat.diet_post.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {
    private int page;     // 요청 페이지 번호 (0부터 시작)
    private int size;     // 한 페이지당 게시물 수

    public int getOffset() {
        return page * size;
    }
}

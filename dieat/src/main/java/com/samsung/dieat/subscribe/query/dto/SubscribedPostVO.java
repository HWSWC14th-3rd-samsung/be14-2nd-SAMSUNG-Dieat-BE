package com.samsung.dieat.subscribe.query.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubscribedPostVO {
    private String title;
    private LocalDateTime createdAt;
    private int viewCount;
    private int commentCount;
    private int likeCount;
    private String nickname;
    private int postCode;
    private String postType; // "FREE", "DIET", "SUCCESS"
}

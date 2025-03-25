package com.samsung.dieat.success_post.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SuccessPostResponseDTO {
    private int succCode;
    private int userCode;
    private String succTitle;
    private String succConts;
    private String succTime;
    private LocalDateTime succCreatedAt;

}

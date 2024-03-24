package com.example.solving.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentRequest {

    private String userNickname;
    private String message;
    private String fileUrl;
}

package com.example.solving.dto;

import com.example.solving.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponse {
    private Long id;

    private String userNickname;
    private String message;
    private String fileUrl;
    private LocalDateTime typedTime;
}

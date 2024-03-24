package com.example.solving.dto;

import com.example.solving.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerResponse {
    private Long id;
    private String userNickname;
    private String title;
    private LocalDateTime time;
}

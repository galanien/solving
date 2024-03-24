package com.example.solving.dto;

import com.example.solving.entity.Answer;
import com.example.solving.entity.Comment;
import com.example.solving.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String name;
    private String description;
    private String fileUrl;
    private LocalDateTime createdTime;

    private String authorNickname;

    private AnswerResponse answer;

    private List<CommentResponse> comments;

}

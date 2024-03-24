package com.example.solving.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    private String name;
    private String description;
    private String fileUrl;
    private Long userId;
}

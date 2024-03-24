package com.example.solving.service;

import com.example.solving.dto.TaskRequest;
import com.example.solving.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    void createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();
}

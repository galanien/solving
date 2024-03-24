package com.example.solving.service;

import com.example.solving.dto.CommentRequest;
import com.example.solving.dto.CommentResponse;
import com.example.solving.dto.TaskRequest;
import com.example.solving.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    void createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    void commentToTheTask(Long taskId, CommentRequest request);

    List<CommentResponse> getAllTaskCommemnts(Long taskId);

    void setAnswer(Long commentId);
}

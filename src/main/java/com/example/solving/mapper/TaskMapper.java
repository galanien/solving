package com.example.solving.mapper;

import com.example.solving.dto.TaskResponse;
import com.example.solving.entity.Task;

import java.util.List;

public interface TaskMapper {
    List<TaskResponse> toDtoS(List<Task> all);

    TaskResponse toDto(Task task);
}

package com.example.solving.service.impl;

import com.example.solving.dto.TaskRequest;
import com.example.solving.dto.TaskResponse;
import com.example.solving.dto.UserRequest;
import com.example.solving.entity.Task;
import com.example.solving.entity.User;
import com.example.solving.exception.BadRequestException;
import com.example.solving.mapper.TaskMapper;
import com.example.solving.repository.TaskRepository;
import com.example.solving.repository.UserRepository;
import com.example.solving.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;
    @Override
    public void createTask(TaskRequest request) {
        Optional<User> user = userRepository.findById(request.getUserId());
        if (user.isEmpty())
            throw new BadRequestException("user not found with id: "+ request.getUserId());

        Task task = new Task();
        task.setCreatedBy(user.get());
        task.setCreatedTime(LocalDateTime.now());
        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setFileUrl(request.getFileUrl());
        taskRepository.save(task);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        user.get().setCreatedTasks(tasks);
        userRepository.save(user.get());

    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskMapper.toDtoS(taskRepository.findAll());
    }
}

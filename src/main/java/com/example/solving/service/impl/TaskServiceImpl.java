package com.example.solving.service.impl;

import com.example.solving.dto.*;
import com.example.solving.entity.Comment;
import com.example.solving.entity.Task;
import com.example.solving.entity.User;
import com.example.solving.exception.BadRequestException;
import com.example.solving.mapper.CommentMapper;
import com.example.solving.mapper.TaskMapper;
import com.example.solving.repository.CommentRepository;
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
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
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

    @Override
    public void commentToTheTask(Long taskId, CommentRequest request) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty())
            throw new BadRequestException("task not found with id: "+ taskId);
        Optional<User> user = userRepository.findByNickname(request.getUserNickname());
        if (user.isEmpty())
            throw new BadRequestException("user not found with nickname: "+ request.getUserNickname());

        List<Comment> comments = task.get().getComments();
        Comment comment = new Comment();
        comment.setFileUrl(request.getFileUrl());
        comment.setUser(user.get());
        comment.setMessage(request.getMessage());
        comment.setTypedTime(LocalDateTime.now());
        commentRepository.save(comment);
        comments.add(comment);

        task.get().setComments(comments);


    }

    @Override
    public List<CommentResponse> getAllTaskCommemnts(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty())
            throw new BadRequestException("task not found with id: "+ taskId);
        return commentMapper.toDtoS(task.get().getComments());
    }


}

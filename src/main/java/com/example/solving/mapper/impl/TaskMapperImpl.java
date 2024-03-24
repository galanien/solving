package com.example.solving.mapper.impl;

import com.example.solving.dto.TaskResponse;
import com.example.solving.entity.Task;
import com.example.solving.mapper.AnswerMapper;
import com.example.solving.mapper.CommentMapper;
import com.example.solving.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMapperImpl implements TaskMapper {
    private final AnswerMapper answerMapper;
    private final CommentMapper commentMapper;
    @Override
    public List<TaskResponse> toDtoS(List<Task> all) {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task task: all)
            taskResponses.add(toDto(task));
        return taskResponses;
    }
    @Override
    public TaskResponse toDto(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setCreatedTime(task.getCreatedTime());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setFileUrl(task.getFileUrl());
        taskResponse.setAuthorNickname(task.getCreatedBy()!=null? task.getCreatedBy().getNickname(): null);
        taskResponse.setAnswer(task.getAnswer()!=null? answerMapper.toDto(task.getAnswer()):null);
        taskResponse.setComments(commentMapper.toDtoS(task.getComments()));
        return taskResponse;
    }
}

package com.example.solving.controller;

import com.example.solving.dto.TaskRequest;
import com.example.solving.dto.TaskResponse;
import com.example.solving.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public void createTask(@RequestBody TaskRequest request){
        taskService.createTask(request);
    }
    @GetMapping("/all")
    public List<TaskResponse> allTasks(){
        return taskService.getAllTasks();
    }



}

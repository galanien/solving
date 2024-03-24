package com.example.solving.controller;


import com.example.solving.dto.CommentRequest;
import com.example.solving.dto.CommentResponse;
import com.example.solving.service.TaskService;
import com.example.solving.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final TaskService taskService;
    private final UserService userService;

    @PostMapping("/{taskId}")
    public void commentToTheTask(@PathVariable Long taskId, @RequestBody CommentRequest request){
        taskService.commentToTheTask(taskId, request);
    }

    @GetMapping("/all/{taskId}")
    public List<CommentResponse> allComments(@PathVariable Long taskId){
        return taskService.getAllTaskCommemnts(taskId);
    }
    @PostMapping("/answer/{commentId}")
    public void setItsAnswer(@PathVariable Long commentId){
        taskService.setAnswer(commentId);
    }
}

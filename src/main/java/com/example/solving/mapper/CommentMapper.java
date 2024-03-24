package com.example.solving.mapper;

import com.example.solving.dto.CommentResponse;
import com.example.solving.entity.Comment;

import java.util.List;

public interface CommentMapper {
    List<CommentResponse> toDtoS(List<Comment> comments);

    CommentResponse toDto(Comment comment);
}

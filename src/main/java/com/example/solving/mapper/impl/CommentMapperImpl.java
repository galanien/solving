package com.example.solving.mapper.impl;

import com.example.solving.dto.CommentResponse;
import com.example.solving.entity.Comment;
import com.example.solving.mapper.CommentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentMapperImpl implements CommentMapper {
    @Override
    public List<CommentResponse> toDtoS(List<Comment> comments) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment: comments)
            commentResponses.add(toDto(comment));
        return commentResponses;
    }

    @Override
    public CommentResponse toDto(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setMessage(comment.getMessage());
        commentResponse.setFileUrl(comment.getFileUrl());
        commentResponse.setTypedTime(comment.getTypedTime());
        commentResponse.setUserNickname(comment.getUser().getNickname());
        return commentResponse;
    }
}

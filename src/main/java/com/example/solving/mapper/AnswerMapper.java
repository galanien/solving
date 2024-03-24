package com.example.solving.mapper;

import com.example.solving.dto.AnswerResponse;
import com.example.solving.entity.Answer;

public interface AnswerMapper {
    AnswerResponse toDto(Answer answer);
}

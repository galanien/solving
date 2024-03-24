package com.example.solving.mapper.impl;

import com.example.solving.dto.AnswerResponse;
import com.example.solving.entity.Answer;
import com.example.solving.mapper.AnswerMapper;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapperImpl implements AnswerMapper {
    @Override
    public AnswerResponse toDto(Answer answer) {
        AnswerResponse answerResponse = new AnswerResponse();
        answerResponse.setId(answer.getId());
        answerResponse.setTime(answer.getTime());
        answerResponse.setTitle(answer.getTitle());
        answerResponse.setUserNickname(answer.getUser()!=null? answer.getUser().getNickname(): null);

        return null;
    }
}

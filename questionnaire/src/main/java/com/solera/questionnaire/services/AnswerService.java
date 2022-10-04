package com.solera.questionnaire.services;

import com.solera.questionnaire.models.Answer;
import org.springframework.http.ResponseEntity;

public interface AnswerService {

    public Answer saveAnswer(Answer answer);
    public Answer getAnswerById(int id);
    public void deleteAnswerById(int id);
}

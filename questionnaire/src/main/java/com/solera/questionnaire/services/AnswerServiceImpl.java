package com.solera.questionnaire.services;

import com.solera.questionnaire.exceptions.ResourceNotFoundException;
import com.solera.questionnaire.models.Answer;
import com.solera.questionnaire.models.Question;
import com.solera.questionnaire.repositories.AnswerRepository;
import com.solera.questionnaire.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer saveAnswer(Answer answer) {
        Answer newAnswer = answerRepository.save(answer);
        return newAnswer;
    }

    @Override
    public Answer getAnswerById(int id) {
        return answerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer", id));
    }

    @Override
    public void deleteAnswerById(int id) {

    }
}

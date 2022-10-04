package com.solera.questionnaire.services;

import com.solera.questionnaire.exceptions.ResourceNotFoundException;
import com.solera.questionnaire.models.Question;
import com.solera.questionnaire.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        Question newQuestion = questionRepository.save(question);
        return newQuestion;
    }

    @Override
    public Question getQuestionById(int id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question", id));
    }

    @Override
    public void deleteQuestionById(int id) {

    }
}

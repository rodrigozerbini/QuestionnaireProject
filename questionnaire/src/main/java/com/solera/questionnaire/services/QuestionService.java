package com.solera.questionnaire.services;

import com.solera.questionnaire.models.Question;

import java.util.List;

public interface QuestionService {

    public Question saveQuestion(Question question);
    public Question getQuestionById(int id);
    public void deleteQuestionById(int id);
    public List<Question> getQuestions();
}

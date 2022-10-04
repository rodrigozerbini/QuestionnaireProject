package com.solera.questionnaire.controllers;

import com.solera.questionnaire.models.Question;
import com.solera.questionnaire.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    private int questionCounter = 1;

    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable int id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @GetMapping("/next")
    public ResponseEntity<Question> nextQuestion() {

        Question question = questionService.getQuestionById((questionCounter));
        int numberOfQuestions = questionService.getQuestions().size();
        if (questionCounter < numberOfQuestions) {
            questionCounter++;
        }
        else questionCounter = 1;
        return ResponseEntity.ok(question);
    }

    @GetMapping
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

}

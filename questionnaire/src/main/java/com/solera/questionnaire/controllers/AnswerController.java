package com.solera.questionnaire.controllers;

import com.solera.questionnaire.models.Answer;
import com.solera.questionnaire.models.Question;
import com.solera.questionnaire.services.AnswerService;
import com.solera.questionnaire.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    private int questionCounter = 1;

    @PostMapping
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.saveAnswer(answer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable int id) {
        return ResponseEntity.ok(answerService.getAnswerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable int id) {
        answerService.deleteAnswerById(id);
        return new ResponseEntity<>("Answer deleted successfully", HttpStatus.OK);
    }
}

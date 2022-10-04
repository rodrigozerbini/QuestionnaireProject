package com.solera.questionnaire.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "text", "questionType"})})
public class Question {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String text;
    private String questionType;

    private ArrayList<String> questionOptions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answer answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public ArrayList<String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(ArrayList<String> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public Question(String text, String questionType, ArrayList<String> questionOptions) {
        this.text = text;
        this.questionType = questionType;
        this.questionOptions = questionOptions;
    }

    public Question() {

    }
}

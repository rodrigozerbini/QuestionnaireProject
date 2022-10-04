package com.solera.questionnaire.models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "answer")
    private Question question;

    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer(Question question, String text) {
        this.question = question;
        this.text = text;
    }

    public Answer() {

    }
}

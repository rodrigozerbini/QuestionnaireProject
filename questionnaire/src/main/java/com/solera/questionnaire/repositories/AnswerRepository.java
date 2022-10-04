package com.solera.questionnaire.repositories;

import com.solera.questionnaire.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}

package com.solera.questionnaire;

import com.solera.questionnaire.algorithm.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);

//		Calculator calculator = new Calculator();
//
//		calculator.updateScores(true);
//		calculator.updateScores(true);
//		calculator.updateScores(true);
//		System.out.println(calculator.toString());
	}

}

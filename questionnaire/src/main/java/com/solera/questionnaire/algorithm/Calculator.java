package com.solera.questionnaire.algorithm;

import com.solera.questionnaire.models.Answer;
import com.solera.questionnaire.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Calculator {

//    Once the user completes the questionnaire, the answers will be used to compute the affinity.
//    This is how the algorithm works:
//
//    -Boolean question:
//    You answer Yes, and you add +10 to DATA, -5 to LOGISTICS, +15 to IDENTITY,
//                                +10 to validation, +10 to FIDELIZATION, -15 to PAYMENTS.
//    You answer NO, and you do the opposite (-10 to DATA, +5 to LOGISTICS, etc).

    private int dataScore;
    private int logisticsScore;
    private int identityScore;
    private int validationScore;
    private int fidelizationScore;
    private int paymentsScore;

    public void updateScores(boolean answerText) {
        if(answerText) {
            dataScore += 10;
            logisticsScore -= 5;
            identityScore += 15;
            validationScore += 10;
            fidelizationScore += 10;
            paymentsScore -= 15;
        }
        else {
            dataScore -= 10;
            logisticsScore += 5;
            identityScore -= 15;
            validationScore -= 10;
            fidelizationScore -= 10;
            paymentsScore += 15;
        }
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "dataScore=" + dataScore +
                ", logisticsScore=" + logisticsScore +
                ", identityScore=" + identityScore +
                ", validationScore=" + validationScore +
                ", fidelizationScore=" + fidelizationScore +
                ", paymentsScore=" + paymentsScore +
                '}';
    }

    public Calculator() {
        this.dataScore = 0;
        this.logisticsScore = 0;
        this.identityScore = 0;
        this.validationScore = 0;
        this.fidelizationScore = 0;
        this.paymentsScore = 0;
    }
}

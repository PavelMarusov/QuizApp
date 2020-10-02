package com.example.quizapp.ui.model;

import java.util.List;

public class ResultModel {
    List<String> rightAnswer;
    List<String> incorrectAnswer;

    public List<String> getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(List<String> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(List<String> incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }
}
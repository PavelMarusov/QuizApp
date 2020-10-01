package com.example.quizapp.ui.model;

import java.util.List;

public class QuestionModel {
    private String title;
    private String answer_first;
    private String answer_second;
    private String answer_third;
    private String answer_four;
    private String true_answer;

    private boolean isMulti ;
    private boolean isRight ;

    public QuestionModel() {
    }

    public QuestionModel(String title, String answer_first, String answer_second, String answer_third, String answer_four, String true_answer, boolean isMulti) {
        this.title = title;
        this.answer_first = answer_first;
        this.answer_second = answer_second;
        this.answer_third = answer_third;
        this.answer_four = answer_four;
        this.isMulti = isMulti;
        this.true_answer = true_answer;

    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void setTrue_answer(String true_answer) {
        this.true_answer = true_answer;
    }

    public String getTrue_answer() {
        return true_answer;
    }

    public String getAnswer_third() {
        return answer_third;
    }

    public void setAnswer_third(String answer_third) {
        this.answer_third = answer_third;
    }

    public String getAnswer_four() {
        return answer_four;
    }

    public void setAnswer_four(String answer_four) {
        this.answer_four = answer_four;
    }

    public String getTitle() {
        return title;
    }

    public boolean isMulti() {
        return isMulti;
    }

    public void setMulti(boolean multi) {
        isMulti = multi;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer_first() {
        return answer_first;
    }

    public void setAnswer_first(String answer_first) {
        this.answer_first = answer_first;
    }

    public String getAnswer_second() {
        return answer_second;
    }

    public void setAnswer_second(String answer_second) {
        this.answer_second = answer_second;
    }
}

package com.example.quizapp.ui.repository;

import android.util.Log;

import com.example.quizapp.ui.interfaces.IQuizQuestionsService;

public  class QuizRepository implements IQuizQuestionsService {
    private IQuizQuestionsService questionsService;

    public QuizRepository(IQuizQuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Override
    public void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty) {

    }
}

package com.example.quizapp.ui.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.quizapp.ui.interfaces.IHistoryStorage;
import com.example.quizapp.ui.interfaces.IQuizQuestionsService;
import com.example.quizapp.ui.model.QuizModel;
import com.example.quizapp.ui.model.ResultModel;

import java.util.ArrayList;

public  class QuizRepository implements IQuizQuestionsService, IHistoryStorage {
    private IQuizQuestionsService questionsService;

    public QuizRepository(IQuizQuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Override
    public void getQuestions(QuestionsCallback callback, Integer amount, Integer category, String difficulty) {
        questionsService.getQuestions(callback,amount,category,difficulty);
    }

    @Override
    public LiveData<ArrayList<QuizModel>> getAll() {
        return null;
    }

    @Override
    public QuizModel getQuizResult(int id) {
        return null;
    }

    @Override
    public int saveQuizResult(ResultModel resultModel) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}

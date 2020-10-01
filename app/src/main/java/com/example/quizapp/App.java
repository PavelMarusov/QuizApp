package com.example.quizapp;

import android.app.Application;

import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.model.QuestionModel;

public class App extends Application {
    public static QuizAppService appService;
    public static QuestionModel questionModel;
    @Override
    public void onCreate() {
        super.onCreate();
        appService = new QuizAppService();
        questionModel = new QuestionModel();
    }
}
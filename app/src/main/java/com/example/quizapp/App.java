package com.example.quizapp;

import android.app.Application;

import com.example.quizapp.ui.data.network.QuizAppService;

public class App extends Application {
    public static QuizAppService appService;
    @Override
    public void onCreate() {
        super.onCreate();
        appService = new QuizAppService();
    }
}

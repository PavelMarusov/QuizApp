package com.example.quizapp;

import android.app.Application;

import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.repository.QuizRepository;

public class App extends Application {
    public static QuizAppService appService;

    public static QuizRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        appService = new QuizAppService();

        repository = new QuizRepository(appService);

    }
}

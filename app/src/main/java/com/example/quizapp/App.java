package com.example.quizapp;

import android.app.Application;

import androidx.room.Room;

import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.database.QuestionDataBase;
import com.example.quizapp.ui.repository.QuizRepository;

public class App extends Application {
    public static QuizAppService appService;
    public static QuizRepository repository;
    public static QuestionDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        appService = new QuizAppService();
        dataBase = Room.databaseBuilder(getApplicationContext(), QuestionDataBase.class, "db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        repository = new QuizRepository(appService);

    }
}

package com.example.quizapp;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.database.QuestionDataBase;
import com.example.quizapp.ui.repository.QuizRepository;
import com.example.quizapp.util.Preferences;

public class App extends Application {
    public static QuizAppService appService;
    public static QuizRepository repository;
    public static QuestionDataBase dataBase;
    public static Preferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = new Preferences(this);
        appService = new QuizAppService();
        dataBase = Room.databaseBuilder(getApplicationContext(), QuestionDataBase.class, "db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        repository = new QuizRepository(appService);
    }

}

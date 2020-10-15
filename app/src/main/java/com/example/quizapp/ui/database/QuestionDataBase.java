package com.example.quizapp.ui.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quizapp.ui.model.ResultModel;

@Database(entities = ResultModel.class,version = 1)
public abstract class QuestionDataBase extends RoomDatabase {
    public abstract QuestionDao questionDao();
}

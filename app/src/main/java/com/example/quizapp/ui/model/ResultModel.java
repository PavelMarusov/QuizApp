package com.example.quizapp.ui.model;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.quizapp.ui.database.convecters.DateConverter;
import com.example.quizapp.ui.database.convecters.QuestionConverter;

import java.util.ArrayList;
import java.util.Date;
@Entity
public class ResultModel {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "difficulty")
    private String difficulty;
    @ColumnInfo(name = "correctAnswer")
    private int correctAnswer;
//    @TypeConverters(QuestionConverter.class)
//    private ArrayList<QuizModel> list;
//    @TypeConverters(DateConverter.class)
//    private Date data;

    public ResultModel(String category, String difficulty, int correctAnswer) {
        this.category = category;
        this.difficulty = difficulty;
        this.correctAnswer = correctAnswer;
//        this.list = list;
//        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

//    public ArrayList<QuizModel> getList() {
//        return list;
//    }
//
//    public void setList(ArrayList<QuizModel> list) {
//        this.list = list;
//    }
//
//    public Date getData() {
//        return data;
//    }
//
//    public void setData(Date data) {
//        this.data = data;
//    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}

package com.example.quizapp.ui.database.convecters;

import androidx.annotation.Nullable;
import androidx.room.TypeConverter;

import com.example.quizapp.ui.model.QuizModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class QuestionConverter {
    @TypeConverter
    public static String fromStringToGson(@Nullable ArrayList<QuizModel> quizModels) {
        if (quizModels == null) return null;
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<QuizModel>>() {
        }.getType();
        return gson.toJson(quizModels, type);
    }

    @TypeConverter
    public static ArrayList<QuizModel> fromGsonQuestion(@Nullable String json) {
        if (json == null) return null;
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<QuizModel>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}

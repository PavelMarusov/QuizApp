package com.example.quizapp.ui.interfaces;

import androidx.lifecycle.LiveData;

import com.example.quizapp.ui.model.QuestionModel;
import com.example.quizapp.ui.model.QuizModel;
import com.example.quizapp.ui.model.ResultModel;

import java.util.ArrayList;

public interface IHistoryStorage {

    LiveData<ArrayList<QuizModel>> getAll();

    QuizModel getQuizResult(int id);

    int saveQuizResult(ResultModel resultModel);

    void delete (int id);

    void deleteAll();



}

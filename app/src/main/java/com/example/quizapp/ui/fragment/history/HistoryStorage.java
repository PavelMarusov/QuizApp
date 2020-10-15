package com.example.quizapp.ui.fragment.history;

import androidx.lifecycle.LiveData;

import com.example.quizapp.ui.interfaces.IHistoryStorage;
import com.example.quizapp.ui.model.QuizModel;
import com.example.quizapp.ui.model.ResultModel;

import java.util.ArrayList;

public class HistoryStorage implements IHistoryStorage {
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

package com.example.quizapp.ui.presentation.question;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.App;
import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.interfaces.IQuizQuestionsService;
import com.example.quizapp.ui.model.CategoryModel;
import com.example.quizapp.ui.model.QuizModel;
import com.example.quizapp.ui.model.ResultQuiz;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    public MutableLiveData<QuizModel> quizModelLiveData = new MutableLiveData<>();

    public void getQuestions(Integer amount, Integer category, String difficulty) {
        App.appService.getQuestions(new QuizAppService.QuizModelCallback() {
            @Override
            public void onSuccess(QuizModel model) {
                quizModelLiveData.setValue(model);
            }

            @Override
            public void onFailure(Throwable th) {

            }
        }, amount, category, difficulty);
    }

//    public void getQuestionsByRepository(Integer amount, Integer category, String difficulty){
//        App.repository.getQuestions(new IQuizQuestionsService.QuestionsCallback() {
//            @Override
//            public void onSuccess(QuizModel model) {
//                quizModelLiveData.setValue(model);
//            }
//
//            @Override
//            public void onFailure(Throwable th) {
//
//            }
//        },amount,category,difficulty);
//    }
}

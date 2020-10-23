package com.example.quizapp.ui.interfaces;

import com.example.core.IBaseCallback;
import com.example.quizapp.ui.model.QuizModel;

public interface IQuizQuestionsService {

    void getQuestions(QuestionsCallback callback,Integer amount, Integer category, String difficulty);

    interface QuestionsCallback extends IBaseCallback<QuizModel> {
        @Override
        void onSuccess(QuizModel model);

        @Override
        void onFailure(Throwable th);
    }
}

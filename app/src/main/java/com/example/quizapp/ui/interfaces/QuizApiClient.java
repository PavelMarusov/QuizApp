package com.example.quizapp.ui.interfaces;

import com.example.quizapp.ui.model.CategoryModel;

public interface QuizApiClient {

    void getCategory(CategoryCallback callback);
    interface CategoryCallback extends IBaseCallback<CategoryModel>{
        @Override
        void onSuccess(CategoryModel result);

        @Override
        void onFailure(Throwable th);
    }
}

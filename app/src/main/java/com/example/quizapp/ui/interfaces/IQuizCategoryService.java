package com.example.quizapp.ui.interfaces;

import com.example.core.IBaseCallback;
import com.example.quizapp.ui.model.CategoryModel;

public interface IQuizCategoryService {

    void getCategory(CategoryCallback callback);
    interface CategoryCallback extends IBaseCallback<CategoryModel> {
        @Override
        void onSuccess(CategoryModel result);

        @Override
        void onFailure(Throwable th);
    }


}

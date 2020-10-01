package com.example.quizapp.ui.fragment.main;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.App;
import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.model.CategoryModel;
import com.example.quizapp.ui.model.Trivia_category;

import java.lang.reflect.Array;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<CategoryModel> categoryLiveData = new MutableLiveData<>();


    public void plusPress() {
       if (mutableLiveData.getValue()==null){
           mutableLiveData.setValue(0);
       }
       mutableLiveData.setValue(mutableLiveData.getValue() + 1);


    }
    public void minusPressed(){
        if (mutableLiveData.getValue()==null){
            mutableLiveData.setValue(0);
        }
        mutableLiveData.setValue(mutableLiveData.getValue() - 1);
    }

    public void getCategory(){
        App.appService.getCategories(new QuizAppService.QuizApiCallback() {
            @Override
            public void onSuccess(CategoryModel categoryModel) {

                categoryLiveData.setValue(categoryModel);
            }

            @Override
            public void onFailure(Throwable th) {

            }
        });
    }



}

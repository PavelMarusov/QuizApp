package com.example.quizapp.ui.fragment.main;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();


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



}

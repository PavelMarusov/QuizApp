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
        final int[] num = {0};

    public void plusPress(Button plus) {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mutableLiveData.postValue(num[0]++);
                Log.d("pop", "plus="+ num[0]);
            }
        });
    }
    public void minusPressed(Button minus){
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mutableLiveData.postValue(num[0] --);
            }
        });
    }

    public void onProgressChange(AppCompatSeekBar seekBar, final TextView counter) {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                counter.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}

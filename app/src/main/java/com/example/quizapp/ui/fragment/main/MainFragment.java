package com.example.quizapp.ui.fragment.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quizapp.MainActivity;
import com.example.quizapp.R;
import com.example.quizapp.ui.presentation.QuestionActivity;

import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView counter, mainCounter;
    private AppCompatSeekBar seekBar;
    private Button plus_btn, minus_btn,start_btn;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        counter = view.findViewById(R.id.seek_bar_counter);
        mainCounter = view.findViewById(R.id.main_counter);
        seekBar = view.findViewById(R.id.main_fr_seekBar);
        plus_btn = view.findViewById(R.id.main_plus_btn);
        minus_btn = view.findViewById(R.id.main_minus_btn);
        start_btn = view.findViewById(R.id.main_start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.mutableLiveData.observe(Objects.requireNonNull(getActivity()), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mainCounter.setText(String.valueOf(integer));
            }
        });
      onProgressChange();
       plus_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mViewModel.plusPress();
           }
       });
        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.minusPressed();
            }
        });


    }
    public void onProgressChange() {
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

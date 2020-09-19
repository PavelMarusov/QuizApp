package com.example.quizapp.ui.fragment.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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

import com.example.quizapp.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView counter, mainCounter;
    private AppCompatSeekBar seekBar;
    private Button plus_btn, minus_btn;


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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.onProgressChange(seekBar,counter);
        mViewModel.plusPress(plus_btn);
        mViewModel.minusPressed(minus_btn);
        mViewModel.mutableLiveData.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mainCounter.setText(String.valueOf(integer));
            }
        });


    }


}

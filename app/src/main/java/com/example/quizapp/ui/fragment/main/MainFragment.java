package com.example.quizapp.ui.fragment.main;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.ui.model.CategoryModel;
import com.example.quizapp.ui.model.Trivia_category;
import com.example.quizapp.ui.presentation.question.QuestionActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView counter, mainCounter;
    private AppCompatSeekBar seekBar;
    private AppCompatSpinner spinner;
    private Button plus_btn, minus_btn,start_btn;
    private int id;
    private  String categoryName;


    public static MainFragment newInstance()
    { return new MainFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        counter = view.findViewById(R.id.seek_bar_counter);
        mainCounter = view.findViewById(R.id.main_counter);
        seekBar = view.findViewById(R.id.main_fr_seekBar);
        spinner =view.findViewById(R.id.main_category_spinner);
        plus_btn = view.findViewById(R.id.main_plus_btn);
        minus_btn = view.findViewById(R.id.main_minus_btn);
        start_btn = view.findViewById(R.id.main_start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                intent.putExtra("categori",id);
                intent.putExtra("name",categoryName);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getCategory();
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
        mViewModel.categoryLiveData.observe(getActivity(), new Observer <CategoryModel>() {
            @Override
            public void onChanged(CategoryModel categoryModel) {
                List<Trivia_category> trivia_categories = categoryModel.getTrivia_categories();
             List<String> list = new ArrayList<>();
             for ( Trivia_category trivia_categorys: trivia_categories){
                 list.add(trivia_categorys.getName());
                 ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_dropdown_item, list);
                 spinner.setAdapter(adapter);
                 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                     @Override
                     public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                         id = categoryModel.getTrivia_categories().get(i).getId();
                         categoryName = categoryModel.getTrivia_categories().get(i).getName();
                     }

                     @Override
                     public void onNothingSelected(AdapterView<?> adapterView) {

                     }
                 });
             }
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

package com.example.quizapp.ui.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.quizapp.R;
import com.example.quizapp.ui.adapter.ListQuestionAdapter;
import com.example.quizapp.ui.interfaces.OnItemClicked;
import com.example.quizapp.ui.model.QuestionModel;
import com.example.quizapp.ui.viewModel.QuestionModelRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements OnItemClicked {
    private ListQuestionAdapter adapter;
    private RecyclerView recyclerView;
    private List<QuestionModel> list;
    public MutableLiveData<Integer> liveData = new MutableLiveData<>();
    private ProgressBar progressBar;
    private TextView categoryTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        progressBar = findViewById(R.id.quest_progress_bar);
        recyclerView = findViewById(R.id.question_rv);
        categoryTV = findViewById(R.id.quest_category_tv);
        list = new QuestionModelRepository().getQuestionList();
        adapter = new ListQuestionAdapter(list, this);
        recyclerView.setAdapter(adapter);
        Intent intent = getIntent();
        int id =intent.getIntExtra("categori",0);
        categoryTV.setText(intent.getStringExtra("name"));


    }

    @Override
    public void onItemClick() {
        if (liveData.getValue() == null){
            liveData.setValue(0);

        }
        liveData.setValue(liveData.getValue()+1);
        recyclerView.scrollToPosition(liveData.getValue());
        Log.d("pop","onItemClick" );
    }
}

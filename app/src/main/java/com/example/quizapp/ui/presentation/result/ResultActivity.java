package com.example.quizapp.ui.presentation.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.MainActivity;
import com.example.quizapp.R;
import com.example.quizapp.util.Config;

public class ResultActivity extends AppCompatActivity {
    private ResultViewModel mViewModel;
    private Button buttonFinish;
    private TextView category, difficulty, allResult, rightAns, incorrectAns;
    private Integer rightAnswer;
    private Integer allQuestion;
    private Double procent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        buttonFinish = findViewById(R.id.result_finish_btn);
        category = findViewById(R.id.result_card_category);
        difficulty = findViewById(R.id.r_difficulty_set);
        rightAns = findViewById(R.id.r_correct_answer_left);
        incorrectAns = findViewById(R.id.r_correct_answer_right);
        allResult = findViewById(R.id.r_result_set);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        category.setText(intent.getStringExtra(Config.KEY_CATEGORY));
        difficulty.setText(intent.getStringExtra(Config.KEY_DIFFICULTY));
        rightAnswer = intent.getIntExtra(Config.KEY_ANSWER, 0);
        allQuestion = intent.getIntExtra(Config.KEY_AMOUNT, 0);

        procent = (double)rightAnswer / allQuestion;
        int n = (int) (procent *100);
        allResult.setText(String.valueOf(n)+"%");
        rightAns.setText(String.valueOf(rightAnswer));
        incorrectAns.setText(String.valueOf(allQuestion));


    }
}

package com.example.quizapp.ui.presentation.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.MainActivity;
import com.example.quizapp.R;

public class ResultActivity extends AppCompatActivity {
private ResultViewModel mViewModel;
private Button buttonFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        buttonFinish = findViewById(R.id.result_finish_btn);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

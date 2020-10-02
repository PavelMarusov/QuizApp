package com.example.quizapp.ui.presentation.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.MainActivity;
import com.example.quizapp.R;
import com.example.quizapp.util.Config;

public class ResultActivity extends AppCompatActivity {
private ResultViewModel mViewModel;
private Button buttonFinish;
private TextView category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        buttonFinish = findViewById(R.id.result_finish_btn);
        category = findViewById(R.id.result_card_category);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        category.setText(intent.getStringExtra(Config.KEY_CATEGORY));


    }
}

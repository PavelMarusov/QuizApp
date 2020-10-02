package com.example.quizapp.ui.presentation.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizapp.App;
import com.example.quizapp.R;
import com.example.quizapp.ui.adapter.ListQuestionAdapter;
import com.example.quizapp.ui.data.network.QuizAppService;
import com.example.quizapp.ui.interfaces.IAnswerCheck;
import com.example.quizapp.ui.interfaces.OnItemClicked;
import com.example.quizapp.ui.model.QuestionModel;
import com.example.quizapp.ui.model.QuizModel;
import com.example.quizapp.ui.model.ResultModel;
import com.example.quizapp.ui.model.ResultQuiz;
import com.example.quizapp.ui.presentation.result.ResultActivity;
import com.example.quizapp.ui.viewModel.QuestionModelRepository;
import com.example.quizapp.util.Config;

import java.util.List;

import javax.xml.transform.Result;

public class QuestionActivity extends AppCompatActivity implements OnItemClicked, QuizAppService.QuizModelCallback,IAnswerCheck {
    private ListQuestionAdapter adapter;
    private RecyclerView recyclerView;
    private List<ResultQuiz> list;
    public MutableLiveData<Integer> liveData = new MutableLiveData<>();
    private ProgressBar progressBar;
    private TextView categoryTV,back,progressStart,getProgressEnd;
    private Integer amount;
    private Integer category_id;
    private Integer count = 1;
    private String category_name;
    private String difficulty;
    private ResultModel resultModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        progressBar = findViewById(R.id.quest_progress_bar);
        recyclerView = findViewById(R.id.question_rv);
        categoryTV = findViewById(R.id.quest_category_tv);
        back= findViewById(R.id.quest_back_tv);
        progressStart = findViewById(R.id.quest_progressStart);
        getProgressEnd = findViewById(R.id.quest_progressEnd);
        resultModel = new ResultModel();
        intentGet();
        backPressed();
        if(difficulty.equals("Any difficulty")){
            App.appService.getQuestions(this,amount,category_id,null);
        }
        App.appService.getQuestions(this,amount,category_id,difficulty);

    }






    public void intentGet(){
        Intent intent = getIntent();
        category_id = intent.getIntExtra(Config.KEY_CATEGORY, 9);
        category_name = intent.getStringExtra(Config.KEY_NAME);
        difficulty = intent.getStringExtra(Config.KEY_DIFFICULTY);
        amount = intent.getIntExtra(Config.KEY_AMOUNT,0);
        categoryTV.setText(intent.getStringExtra(Config.KEY_NAME));
        progressBar.setMax(amount);
        getProgressEnd.setText(amount+"");
        Log.d("pop","get intent = "+amount+" " + category_id+" "+difficulty);
    }
    public void backPressed(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveData.setValue(liveData.getValue()-1);
                recyclerView.scrollToPosition(liveData.getValue());
            }
        });
    }




    @Override
    public void onItemClick() {
        if (liveData.getValue() == null) {
            liveData.setValue(0);
        }
        new CountDownTimer(500, 500) {
            @Override
            public void onTick(long l) {}
            @Override
            public void onFinish() {
                if (liveData.getValue() == (list.size() - 1)){
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    intent.putExtra(Config.KEY_CATEGORY,category_name);
                    intent.putExtra(Config.KEY_DIFFICULTY,difficulty);
                    startActivity(intent);

                }else {
                    liveData.setValue(liveData.getValue() + 1);
                    recyclerView.scrollToPosition(liveData.getValue());
                    count++;
                    progressBar.setProgress(count);
                    progressStart.setText(liveData.getValue() +"");
                }
            }
        }.start();


    }


    @Override
    public void onSuccess(QuizModel model) {
        list = model.getResults();
        adapter = new ListQuestionAdapter(list, this,this::getAnswer);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Throwable th) {

    }

    @Override
    public void getAnswer(ResultModel model) {

    }
}

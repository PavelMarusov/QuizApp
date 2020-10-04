package com.example.quizapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.quizapp.R;
import com.example.quizapp.databinding.ListQuestionBinding;

import com.example.quizapp.ui.interfaces.OnItemClicked;
import com.example.quizapp.ui.model.ResultQuiz;

import java.util.Collections;
import java.util.List;


public class ListQuestionAdapter extends RecyclerView.Adapter<ListQuestionAdapter.QuestionsHolder> {
    private List<ResultQuiz> list;
    private OnItemClicked listner;




    public ListQuestionAdapter(List<ResultQuiz> list, OnItemClicked listener) {
        this.list = list;
        this.listner = listener;

    }

    @NonNull
    @Override
    public QuestionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListQuestionBinding binding = DataBindingUtil.
                bind(LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.list_question, parent, false));
        return new QuestionsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class QuestionsHolder extends RecyclerView.ViewHolder {
        private ListQuestionBinding binding;
        private String answerTrue;


        public QuestionsHolder(ListQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.questSkipBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);
                }
            });

            binding.questAnswer1Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer1Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer1Tv);
                    listner.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);


                }
            });
            binding.questAnswer2Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer2Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer2Tv);
                    listner.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);

                }
            });
            binding.questAnswer3Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer3Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer3Tv);
                    listner.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);
                }
            });
            binding.questAnswer4Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = binding.questAnswer4Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer4Tv);
                    listner.onItemClick();
                    binding.questAnswer1Tv.setEnabled(false);
                    binding.questAnswer2Tv.setEnabled(false);
                    binding.questAnswer3Tv.setEnabled(false);
                    binding.questAnswer4Tv.setEnabled(false);


                }
            });
        }

        public void onBind(ResultQuiz model) {
            answerTrue = model.getCorrect_answer();
            binding.questTitleTv.setText(model.getQuestion());
            binding.questAnswer1Tv.setEnabled(true);
            binding.questAnswer2Tv.setEnabled(true);
            binding.questAnswer3Tv.setEnabled(true);
            binding.questAnswer4Tv.setEnabled(true);
            binding.questAnswer1Tv.setBackgroundResource(R.drawable.qustion_answer_bg);
            binding.questAnswer2Tv.setBackgroundResource(R.drawable.qustion_answer_bg);
            binding.questAnswer3Tv.setBackgroundResource(R.drawable.qustion_answer_bg);
            binding.questAnswer4Tv.setBackgroundResource(R.drawable.qustion_answer_bg);
            if (model.getIncorrect_answers().size() == 1) {
                binding.questAnswer2Tv.setVisibility(View.GONE);
                binding.questAnswer4Tv.setVisibility(View.GONE);
                binding.questAnswer1Tv.setText(model.getCorrect_answer());
                binding.questAnswer3Tv.setText(model.getIncorrect_answers().get(0));

            } else {
                List<String> answers = model.getIncorrect_answers();
                answers.add(model.getCorrect_answer());
                Collections.shuffle(answers);
                binding.questAnswer1Tv.setText(answers.get(0));
                binding.questAnswer2Tv.setText(answers.get(1));
                binding.questAnswer3Tv.setText(answers.get(2));
                binding.questAnswer4Tv.setText(answers.get(3));
            }
        }

        public void isTryAnswer(String answer, String tryAnswer, TextView textView) {

            if (answer.contains(tryAnswer)) {
                textView.setBackgroundResource(R.color.colorAccent);
                listner.isAnswerTry(true);
                YoYo.with(Techniques.RotateIn).duration(700).repeat(5).playOn(textView);
            }
            else {
                textView.setBackgroundResource(R.color.colorRed);
                listner.isAnswerTry(false);
                YoYo.with(Techniques.Bounce).duration(700).repeat(5).playOn(textView);

            }
        }
    }
}

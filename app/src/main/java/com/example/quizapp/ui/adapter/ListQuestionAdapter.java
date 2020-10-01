package com.example.quizapp.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ListQuestionBinding;
import com.example.quizapp.ui.interfaces.OnItemClicked;
import com.example.quizapp.ui.model.QuestionModel;
import java.util.List;


public class ListQuestionAdapter extends RecyclerView.Adapter<ListQuestionAdapter.QuestionsHolder> {
    private List<QuestionModel> list;
    private OnItemClicked listner;


    public ListQuestionAdapter(List<QuestionModel> list, OnItemClicked listener) {
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
        boolean isTry;
        private int counterTru;
        private int counterFalse;
        private int count = 1;


        public QuestionsHolder(ListQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.questSkipBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });

            binding.questAnswer1Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("pop", "onClick");
                    String s = binding.questAnswer1Tv.getText() + "";
                    isTryAnswer(s, answerTrue, binding.questAnswer1Tv);
                    listner.onItemClick();
                    binding.questProgressStart.setText(count+"");
                    binding.questProgressBar.setProgress(10);
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

        public void onBind(QuestionModel model) {
            answerTrue = list.get(getAdapterPosition()).getTrue_answer();
            binding.questTitleTv.setText(model.getTitle());
            binding.questProgressEnd.setText(list.size()+"");
            if (!model.isMulti()) {
                binding.questAnswer2Tv.setVisibility(View.GONE);
                binding.questAnswer4Tv.setVisibility(View.GONE);
                binding.questAnswer1Tv.setText(model.getAnswer_first());
                binding.questAnswer3Tv.setText(model.getAnswer_third());

            } else {
                binding.questAnswer1Tv.setText(model.getAnswer_first());
                binding.questAnswer2Tv.setText(model.getAnswer_second());
                binding.questAnswer3Tv.setText(model.getAnswer_third());
                binding.questAnswer4Tv.setText(model.getAnswer_four());
            }
        }

        public void isTryAnswer(String answer, String tryAnswer, TextView textView) {
            Log.d("pop", "answer=" + answer);
            Log.d("pop", "tryAnswer=" + tryAnswer);
            if (answer.contains(tryAnswer)) {
                isTry = true;
                textView.setBackgroundResource(R.color.colorAccent);
                counterTru++;
                return;
            }

            textView.setBackgroundResource(R.color.colorRed);
            isTry = false;
            counterFalse++;
            Toast.makeText(itemView.getContext(), "Error", Toast.LENGTH_SHORT).show();

        }
    }
}

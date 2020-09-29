package com.example.quizapp.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                        inflate(R.layout.list_question,parent,false));
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
//        private TextView title, answer1, answer2, answer3, answer4;
ListQuestionBinding binding;
        public QuestionsHolder(ListQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
//            title = itemView.findViewById(R.id.quest_title_tv);
//            answer1 = itemView.findViewById(R.id.quest_answer1_tv);
//            answer2 = itemView.findViewById(R.id.quest_answer2_tv);
//            answer3 = itemView.findViewById(R.id.quest_answer3_tv);
//            answer4 = itemView.findViewById(R.id.quest_answer4_tv);
            binding.questAnswer1Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
            binding.questAnswer2Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
           binding.questAnswer3Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
            binding.questAnswer4Tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
        }

        public void onBind(QuestionModel model) {
            binding.questTitleTv.setText(model.getTitle());
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
    }
}

package com.example.quizapp.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_question, parent, false);
        return new QuestionsHolder(view);
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
        private TextView title, answer1, answer2, answer3, answer4;

        public QuestionsHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.quest_title_tv);
            answer1 = itemView.findViewById(R.id.quest_answer1_tv);
            answer2 = itemView.findViewById(R.id.quest_answer2_tv);
            answer3 = itemView.findViewById(R.id.quest_answer3_tv);
            answer4 = itemView.findViewById(R.id.quest_answer4_tv);
            answer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
            answer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
            answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
            answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClick();
                }
            });
        }

        public void onBind(QuestionModel model) {
            title.setText(model.getTitle());
            if (!model.isMulti()) {
                answer2.setVisibility(View.GONE);
                answer4.setVisibility(View.GONE);
                answer1.setText(model.getAnswer_first());
                answer3.setText(model.getAnswer_third());
            } else {
                answer1.setText(model.getAnswer_first());
                answer2.setText(model.getAnswer_second());
                answer3.setText(model.getAnswer_third());
                answer4.setText(model.getAnswer_four());
            }


        }
    }
}

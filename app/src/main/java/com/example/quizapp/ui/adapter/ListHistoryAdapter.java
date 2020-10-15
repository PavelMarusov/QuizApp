package com.example.quizapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ListHistoryBinding;
import com.example.quizapp.ui.model.ResultModel;

import java.util.List;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.HistoryHolder> {
    private List<ResultModel> list;
    private ListHistoryBinding binding;

    public ListHistoryAdapter(List<ResultModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil
                .bind(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_history, parent, false));
        return new HistoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        binding.historyTitle.setText(list.get(position).getCategory());
        binding.difficultyT.setText(list.get(position).getDifficulty());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(ListHistoryBinding binding) {
            super(binding.getRoot());
        }


    }
}

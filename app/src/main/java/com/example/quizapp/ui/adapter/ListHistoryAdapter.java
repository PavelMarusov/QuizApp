package com.example.quizapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ListHistoryBinding;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.HistoryHolder> {


    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListHistoryBinding binding = DataBindingUtil
                .bind(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_history,parent,false));
        return new HistoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HistoryHolder extends RecyclerView.ViewHolder {
        public HistoryHolder(ListHistoryBinding binding) {
            super(binding.getRoot());
        }
    }
}

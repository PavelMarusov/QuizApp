package com.example.quizapp.ui.fragment.history;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.App;
import com.example.quizapp.R;
import com.example.quizapp.databinding.HistoryFragmentBinding;
import com.example.quizapp.ui.adapter.ListHistoryAdapter;
import com.example.quizapp.ui.model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private HistoryFragmentBinding binding;
    private ListHistoryAdapter adapter;
    private List<ResultModel> list;


    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        list = App.dataBase.questionDao().getAll();
        adapter = new ListHistoryAdapter(list);
        binding.historyRv.setAdapter(adapter);

        App.dataBase.questionDao().getUpdate().observe(getActivity(), new Observer<List<ResultModel>>() {
            @Override
            public void onChanged(List<ResultModel> resultModels) {
                if (list==null){
                
                adapter.notifyDataSetChanged();}
            }
        });


    }

}

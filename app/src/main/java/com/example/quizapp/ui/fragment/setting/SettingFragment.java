package com.example.quizapp.ui.fragment.setting;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.TokenWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizapp.App;
import com.example.quizapp.R;
import com.example.quizapp.databinding.SettingFragmentBinding;

public class SettingFragment extends Fragment implements View.OnClickListener {

    private SettingViewModel mViewModel;
    private SettingFragmentBinding binding;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingViewModel.class);
        binding.clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        App.dataBase.questionDao().deleteAll();
        App.dataBase.questionDao().getUpdate();
        Toast.makeText(getActivity(),"Delete",Toast.LENGTH_LONG).show();
    }
}

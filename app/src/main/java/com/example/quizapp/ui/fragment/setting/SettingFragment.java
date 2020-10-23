package com.example.quizapp.ui.fragment.setting;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.os.TokenWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizapp.App;
import com.example.quizapp.R;
import com.example.quizapp.databinding.SettingFragmentBinding;
import com.example.quizapp.ui.adapter.ListThemeAdapter;
import com.example.quizapp.ui.interfaces.IonCheckBoxLister;
import com.example.quizapp.ui.model.ThemeModel;

import java.util.ArrayList;
import java.util.List;

public class SettingFragment extends Fragment {

    private SettingViewModel mViewModel;
    private SettingFragmentBinding binding;
    private List<ThemeModel> list;
    private ListThemeAdapter adapter;
    ThemeModel model;

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
        initRecycler();
        change();
        clear();
    }

    public void initRecycler() {
        list = new ArrayList<>();
        list.add(model =new ThemeModel(R.color.colorGreenAccent,false));
        list.add(model =new ThemeModel(R.color.colorRed,false));
        list.add(model =new ThemeModel(R.color.colorBlue,false));
        list.add(model =new ThemeModel(R.color.colorBlack,false));
        for (int i = 0; i < list.size(); i++) {
            if (i == App.preferences.getThemePosition())
                list.get(i).setCheck(true);
        }
        adapter = new ListThemeAdapter(list);
        binding.themeRecyclerView.setAdapter(adapter);
    }

    public void change() {
            binding.theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.recyclerCard.setVisibility(View.VISIBLE);
                    adapter.setLister(position -> {
                        list.get(position).setCheck(true);
                        new CountDownTimer(500,500){

                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
                                binding.recyclerCard.setVisibility(View.GONE);
                            }
                        };
                        switch (position){
                            case 0:
                                App.preferences.saveInstance(R.style.GreenTheme);
                                break;
                            case 1:
                                App.preferences.saveInstance(R.style.RedTheme);
                                break;
                            case 2:
                                App.preferences.saveInstance(R.style.BlueTheme);
                                break;
                            case 3:
                                App.preferences.saveInstance(R.style.DarckTheme);
                        }
                        App.preferences.saveInstancePosition(position);
                        Intent intent = requireActivity().getIntent();
                        requireActivity().finish();
                        startActivity(intent);

                    });
                }
            });




    }

    public void clear() {
        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity()).
                        setTitle("Delete history?").
                        setMessage("Are you sure you want to delete you history?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                App.dataBase.questionDao().deleteAll();
                                Toast.makeText(getActivity(), "Delete", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).create();
                dialog.show();
            }
        });
    }
}

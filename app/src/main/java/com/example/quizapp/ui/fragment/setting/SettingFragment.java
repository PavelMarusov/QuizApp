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

import java.util.ArrayList;
import java.util.List;

public class SettingFragment extends Fragment {

    private SettingViewModel mViewModel;
    private SettingFragmentBinding binding;
    private List<Integer> list;
    private ListThemeAdapter adapter;
    private IonCheckBoxLister listener;

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
        list.add(com.example.quizapp.R.color.colorGreenAccent);
        list.add(R.color.colorRed);
        list.add(R.color.colorBlue);
        list.add(R.color.colorBlack);
        adapter = new ListThemeAdapter(list);
        binding.themeRecyclerView.setAdapter(adapter);
    }

    public void change() {
            binding.theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    binding.recyclerCard.setVisibility(View.VISIBLE);
                    adapter.setLister(new IonCheckBoxLister() {
                        @Override
                        public void onCheckBoxPress(int position) {
                            binding.recyclerCard.setVisibility(View.GONE);
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
                            Intent intent = requireActivity().getIntent();
                            requireActivity().finish();
                            startActivity(intent);

                        }
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

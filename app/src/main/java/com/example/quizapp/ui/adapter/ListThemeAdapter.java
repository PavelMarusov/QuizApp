package com.example.quizapp.ui.adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ListThemeBinding;
import com.example.quizapp.ui.interfaces.IonCheckBoxLister;

import java.util.List;

import static android.os.Build.VERSION_CODES.R;

public class ListThemeAdapter extends RecyclerView.Adapter<ListThemeAdapter.Holder> {
    private List<Integer> list;
    private IonCheckBoxLister lister;

    public ListThemeAdapter(List<Integer> list) {

        this.list = list;
    }

    public void setLister(IonCheckBoxLister lister){
        this.lister =lister;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListThemeBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                .inflate(com.example.quizapp.R.layout.list_theme, parent, false));
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ListThemeBinding binding;

        public Holder(ListThemeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    compoundButton.setChecked(true);
                    lister.onCheckBoxPress(getAdapterPosition());
                }
            });
        }

        public void onBind(Integer color) {
            binding.image.setBackgroundResource(color);
        }
    }
}

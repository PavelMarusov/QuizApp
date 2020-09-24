package com.example.quizapp.ui.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NonScrollRecyclerView extends RecyclerView {
    private boolean isScrolling = false;
    public NonScrollRecyclerView(@NonNull Context context) {
        super(context);
    }

    public NonScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NonScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return isScrolling&&super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return isScrolling&& super.onInterceptTouchEvent(e);
    }
}

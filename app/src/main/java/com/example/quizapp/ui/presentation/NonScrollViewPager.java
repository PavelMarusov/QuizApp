package com.example.quizapp.ui.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NonScrollViewPager extends ViewPager {
    private boolean isScrolling = false;
    public NonScrollViewPager (@NonNull Context context) {
        super(context);
    }
    public NonScrollViewPager (@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScrolling && super.onTouchEvent(ev);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrolling && super.onInterceptTouchEvent(ev);
    }
}

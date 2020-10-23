package com.example.quizapp.ui.model;

public class ThemeModel {
    private int color;
    private boolean isCheck;

    public ThemeModel(int color, boolean isCheck) {
        this.color = color;
        this.isCheck = isCheck;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}

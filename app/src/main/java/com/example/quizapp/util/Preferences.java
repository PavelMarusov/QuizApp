package com.example.quizapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Preferences {
    public static final String PREF_KEY = "isClicked";
    public static final String PREF_THEME = "theme";
    private SharedPreferences preferences;
    public static volatile Preferences instance;

    public Preferences(Context context) {
        instance = this;
        preferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public static Preferences getInstance (Context context){
        if (instance==null){
            new Preferences(context); }
        return instance;
    }



    public void saveInstance(int theme){
        Log.d("pop","saveInstance");
        preferences.edit().putInt(PREF_THEME,theme).apply();
    }
    public int getTheme(int defTheme){
      return   preferences.getInt(PREF_THEME,defTheme);
    }
}

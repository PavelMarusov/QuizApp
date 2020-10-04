package com.example.quizapp.ui.interfaces;

public interface IBaseCallback <T> {
    void onSuccess(T result);
    void onFailure(Throwable th);

}
